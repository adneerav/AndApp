package com.example.hb.slidertest;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.hb.andapp.R;
import com.example.hb.basepackage.BaseActivity;

public class SlideTest extends BaseActivity {
    NavigationView navigationview;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slider_test);
        drawerLayout = (DrawerLayout) findViewById(R.id.slider_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.ab_tool);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        setSupportActionBar(toolbar);
        /*
        *Assign drawerLayout to Drawer Toggle
        */
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        /**
         * set Navigation Listner
         */
        navigationview = (NavigationView) findViewById(R.id.navigation_menu_view);
        navigationview.getMenu().findItem(R.id.nav_home).setChecked(true);
        navigationview.setNavigationItemSelectedListener(navigationItemSelectedListener);
        add(new HomeSliderScreen(), R.id.slider_content_frame, false, HomeSliderScreen.TAG);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    private android.os.Handler handler = new android.os.Handler();
    private NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_help:
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            replace(new HelpSlider(), R.id.slider_content_frame, true, HelpSlider.TAG);
                        }
                    }, 200);


                    break;
                case R.id.nav_home:
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            replace(new HomeSliderScreen(), R.id.slider_content_frame, true, HomeSliderScreen.TAG);
                        }
                    }, 200);
                    break;
                case R.id.nav_calendar:
                    menuItem.setChecked(true);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            replace(new CalendarSlider(), R.id.slider_content_frame, true, CalendarSlider.TAG);
                        }
                    }, 200);

                    break;
            }
            return false;
        }
    };
    private SearchView searchView;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerToggle.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }


}
