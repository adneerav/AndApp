package com.example.hb.tooltest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hb.andapp.BaseFragment;
import com.example.hb.andapp.R;

/**
 * Created by hb on 9/15/2015.
 */
public class HelpT extends BaseFragmentT {
    public static final String TAG = "HelpT";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.help_screen_t, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar tool = (Toolbar) view.findViewById(R.id.ab_tool);
        tool.setTitle(TAG);
        int statusBarHeight =((ScreenCustom) getActivity()).getStatusBarHeight();
        tool.setPadding(0, statusBarHeight, 0, 0);
        ((ScreenCustom) getActivity()).setSupportActionBar(tool);

    }
}
