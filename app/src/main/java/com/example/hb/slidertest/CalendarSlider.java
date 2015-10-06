package com.example.hb.slidertest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.hb.andapp.BaseFragment;
import com.example.hb.andapp.R;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by hb on 9/15/2015.
 */
public class CalendarSlider extends BaseFragment {
    public static final String TAG = "CalendarSlider";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calendar_screen_slider, container, false);
    }

    private RelativeLayout relativeLayout;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relative_calendar);

        Button btnChangeDate = (Button) view.findViewById(R.id.change_date);
        btnChangeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                changeDate();
                Snackbar snackbar = Snackbar.make(relativeLayout, "SnackBar test practice", Snackbar.LENGTH_SHORT);
                snackbar.setActionTextColor(Color.CYAN);
                snackbar.setAction("Change TIme ", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        changeDate();
                        Snackbar.make(relativeLayout, "Time Changes  ;)", Snackbar.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });

    }

    private void changeDate() {
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            String command = "date -s " + "20151212.020202" + "\n";
            Log.e("command", command);
            os.writeBytes(command);
            os.flush();
            os.writeBytes("exit\n");
            os.flush();
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
