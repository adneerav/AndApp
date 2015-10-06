package com.example.hb.tooltest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hb.andapp.BaseFragment;
import com.example.hb.andapp.R;

/**
 * Created by hb on 9/15/2015.
 */
public class SettingsT extends BaseFragmentT {
    public static final String TAG = "SettingsT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_screen_t, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtView = (TextView) view.findViewById(R.id.section_label);
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
