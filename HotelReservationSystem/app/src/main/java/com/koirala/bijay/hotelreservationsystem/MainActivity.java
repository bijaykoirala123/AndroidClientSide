package com.koirala.bijay.hotelreservationsystem;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tablayout;
    ViewPager viewpager;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager)findViewById(R.id.view_pager);
        viewpager.setAdapter(new SimpleFragmentPageAdapter(getSupportFragmentManager(), this));

        tablayout = (TabLayout)findViewById(R.id.tab_layout);
        tablayout.setupWithViewPager(viewpager);

        //to add action_menu inside ToolBar
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Hotel Pacific");
        setSupportActionBar(toolbar);

    ////////////Drayer layout toggle menu ///////////////
    drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
    actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);

        return true;
    }
    //////////////method for drawerLayout toggle btn //////////////

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
}
