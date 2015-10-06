package com.example.hb.basepackage;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;

/**
 * Created by hb on 9/24/2015.
 */
public class BaseActivity extends AppCompatActivity {
    protected void replace(Fragment fragment, int containerId, boolean addToStack, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (addToStack) {
            fragmentTransaction.replace(containerId, fragment, tag).addToBackStack(tag).commit();
        } else {
            fragmentTransaction.replace(containerId, fragment).commit();
        }

    }

    public Palette getIconPalette(Bitmap bitmap) {
        return Palette.from(bitmap).generate();

    }

    protected void pop(String tag) {
        getSupportFragmentManager().popBackStack(tag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    protected void add(Fragment fragment, int containerId, boolean addToStack, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (addToStack) {
            fragmentTransaction.add(containerId, fragment, tag).addToBackStack(tag).commit();
        } else {
            fragmentTransaction.add(containerId, fragment).commit();
        }

    }
}
