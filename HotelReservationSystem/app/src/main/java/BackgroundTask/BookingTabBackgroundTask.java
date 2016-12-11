package BackgroundTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.koirala.bijay.hotelreservationsystem.BookingActivity;
import com.koirala.bijay.hotelreservationsystem.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import Adapters.HotelsAdapter;
import model.Hotels;

/**
 * Created by bijay on 11/19/2016.
 */

public class BookingTabBackgroundTask extends AsyncTask<String,Void,String> {
    ProgressDialog progressDialog;
    Context context;
    ListView hotelslistView;
    ArrayList<Hotels> hotelsArrayList;

    public BookingTabBackgroundTask(Context ctx,ListView listView){
        this.context = ctx;
        this.hotelslistView = listView;
    }
    @Override
    protected String doInBackground(String... strings) {

      ////////////////////////  getting context ///////////////////////////

        try {
            URL url = new URL("http://10.0.2.2:8080/HotelReservationSystem/ListHotels");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            outputStreamWriter.flush();
            bufferedWriter.flush();
            bufferedWriter.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String line="";

            while((line = bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("hotels");

            hotelsArrayList = new ArrayList<Hotels>();

            for(int i=0; i<jsonArray.length();i++){
                JSONObject childJsonObject = jsonArray.getJSONObject(i);
                Hotels hotels = new Hotels();
                hotels.setHotel_id(childJsonObject.getInt("hotel_id"));
                hotels.setHotels_name("bijay");
                hotels.setLocation("kathmandu");
                hotels.setBooking_status("available");
                hotelsArrayList.add(hotels);
            }

        } catch (MalformedURLException e) {
            Log.e("error",e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("error",e.getMessage());
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Data is Loading");
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.dismiss();

        //Toast.makeText(context,s+"",Toast.LENGTH_LONG).show();
        HotelsAdapter hotelsAdapter = new HotelsAdapter(context, R.layout.hotels_list_row,hotelsArrayList);
        hotelslistView.setAdapter(hotelsAdapter);

        hotelslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Hotels data = (Hotels)adapterView.getItemAtPosition(i);

                for(int j = 0;j<hotelslistView.getChildCount();j++) {
                    if (i == j) {
                        Intent intent = new Intent(context,BookingActivity.class);
                        intent.putExtra("hotel_name",data.getHotels_name());
                        intent.putExtra("hotel_id",data.getHotel_id());
                        context.startActivity(intent);
                    }
                }
            }
        });
    }
}
