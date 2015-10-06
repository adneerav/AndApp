package com.example.hb.slidertest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hb.andapp.R;

/**
 * Created by hb on 9/15/2015.
 */
public class HelpSlider extends BaseFragmentSlider {
    public static final String TAG = "HelpSlider";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.help_screen_slider, container, false);
    }
}
