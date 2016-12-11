package BackgroundTask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by bijay on 11/30/2016.
 */

public class BookingBackgroundTask extends AsyncTask<String,Void,String> {
    Context context;

    public BookingBackgroundTask(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        String hotel_name = strings[1];
        String hotel_id = strings[0];

        return hotel_id;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,s+"",Toast.LENGTH_LONG).show();
    }
}
