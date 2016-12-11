package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.koirala.bijay.hotelreservationsystem.R;

import java.util.ArrayList;
import model.Hotels;

/**
 * Created by bijay on 11/20/2016.
 */

public class HotelsAdapter extends ArrayAdapter<Hotels> {

    Context context;
    ArrayList<Hotels> hotelsArrayList;
    int Resource;
    LayoutInflater inflater;

    public HotelsAdapter(Context context, int resource, ArrayList<Hotels> objects) {
        super(context, resource, objects);

        this.context = context;
        hotelsArrayList = objects;
        Resource = resource;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(Resource,null);

            viewHolder = new ViewHolder();
            viewHolder.hotels_name = (TextView)convertView.findViewById(R.id.hotels);
            viewHolder.location = (TextView)convertView.findViewById(R.id.location);
            viewHolder.booking_status = (TextView)convertView.findViewById(R.id.booking_status);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.hotels_name.setText(hotelsArrayList.get(position).getHotels_name());
        viewHolder.location.setText(hotelsArrayList.get(position).getLocation());
        viewHolder.booking_status.setText(hotelsArrayList.get(position).getBooking_status());

        return convertView;
    }

    static class ViewHolder{
        public TextView hotels_name;
        public TextView location;
        public TextView booking_status;
    }
}
