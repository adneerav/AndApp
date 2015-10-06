package com.example.hb.tooltest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hb.andapp.R;
import com.example.hb.basepackage.BaseActivity;

/**
 * Created by hb on 9/16/2015.
 */
public class ScreenCustom extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            navigationBarHeight = getResources().getDimensionPixelSize(resourceId);
        }

        add(new HomeScreenT(), R.id.main_frame, false, HomeScreenT.TAG);

    }

    private int navigationBarHeight;

    public int getNavigationBarHeight() {
        return navigationBarHeight;
    }

    public int getStatusBarHeight() {
        return statusBarHeight;
    }

    private int statusBarHeight;



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
                replace(new SettingsT(), R.id.main_frame, true, SettingsT.TAG);
                return true;
            case R.id.action_help:
                replace(new HelpT(), R.id.main_frame, true, HelpT.TAG);
                return true;
            case R.id.action_calendar:
                replace(new CalendarT(), R.id.main_frame, true, CalendarT.TAG);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
