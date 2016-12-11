package com.koirala.bijay.hotelreservationsystem;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bijay on 11/14/2016.
 */
public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    Context context;
    private int pagecount = 4;
    private String[] tabTitle = new String[]{"Home","Facilities","Contacts","Booking"};
    public SimpleFragmentPageAdapter(FragmentManager supportFragmentManager, Context ctx) {
        super(supportFragmentManager);
        this.context = ctx;
    }

    @Override
    public Fragment getItem(int position) {

      if(position == 0) {
          Home homeFragment = new Home();
          return homeFragment;
      }else if(position == 1){
          FacilitiesTab facilitiesTab = new FacilitiesTab();
          return facilitiesTab;
      }else if(position == 2){
          ContactUsTab contactUsTab = new ContactUsTab();
          return contactUsTab;
      }else if(position == 3){
          BookingTab bookingTab = new BookingTab();
          return bookingTab;
      }else{
          return null;
      }
    }

    @Override
    public int getCount() {
        return pagecount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
               return tabTitle[position];
    }
}
