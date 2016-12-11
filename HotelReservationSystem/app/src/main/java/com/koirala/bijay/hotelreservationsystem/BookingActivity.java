package com.koirala.bijay.hotelreservationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import BackgroundTask.BookingBackgroundTask;
import BackgroundTask.BookingTabBackgroundTask;

import static java.lang.String.valueOf;

public class BookingActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //to add action_menu inside ToolBar
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Booking");
        //to set back icon in toolbar
        // onOptionsItemSelected(MenuItem item)
        // helps to triggre previous activity.which method is @overridden below
        toolbar.setNavigationIcon(R.drawable.back_50);
        setSupportActionBar(toolbar);

        //Intent from MainActivity
        Bundle intent = getIntent().getExtras();
        int hotel_id = intent.getInt("hotel_id");
        String hotel_name = intent.getString("hotel_name");

        BookingBackgroundTask bookingBackgroundTask = new BookingBackgroundTask(this);
        bookingBackgroundTask.execute(String.valueOf(hotel_id),hotel_name);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //for back icon( moving to previous activity)
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        // other menu select events may be present here
        return super.onOptionsItemSelected(item);
    }
}
