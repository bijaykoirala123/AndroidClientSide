package com.koirala.bijay.hotelreservationsystem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import BackgroundTask.BookingTabBackgroundTask;

/**
 * Created by bijay on 11/14/2016.
 */
public class BookingTab extends Fragment{
    ListView hotelsListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.booking_tab,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        hotelsListView = (ListView)getActivity().findViewById(R.id.hotelsListView);
        BookingTabBackgroundTask bookingTabBackgroundTask = new BookingTabBackgroundTask(getActivity(),hotelsListView);
        bookingTabBackgroundTask.execute();
    }
}
