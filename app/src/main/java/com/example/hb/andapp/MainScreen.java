package com.example.hb.andapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hb.basepackage.BaseActivity;


public class MainScreen extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.home_selector);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("");
        add(new HomeScreen(), R.id.main_frame, false, HomeScreen.TAG);
    }

    private SearchView searchView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
        return true;
    }

    private Menu menu;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                pop(null);
                return true;
            case R.id.action_settings:
                replace(new SettingsFr(), R.id.main_frame, true, SettingsFr.TAG);
                return true;
            case R.id.action_help:
                replace(new HelpFr(), R.id.main_frame, true, HelpFr.TAG);
                return true;
            case R.id.action_calendar:
                replace(new CalendarFr(), R.id.main_frame, true, CalendarFr.TAG);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
