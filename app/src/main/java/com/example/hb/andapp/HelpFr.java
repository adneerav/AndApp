package com.example.hb.andapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hb on 9/15/2015.
 */
public class HelpFr extends BaseFragment {
    public static final String TAG= "HelpFr";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.help_screen, container, false);
    }
}
