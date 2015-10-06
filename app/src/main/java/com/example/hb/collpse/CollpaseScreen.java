package com.example.hb.collpse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

import com.example.hb.andapp.R;
import com.example.hb.basepackage.BaseActivity;

/**
 * Created by hb on 9/24/2015.
 */
public class CollpaseScreen extends BaseActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout coordinatorLayout;
    AppBarLayout appbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapse_screen_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        appbar = (AppBarLayout) findViewById(R.id.appbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher);
        collapsingToolbarLayout.setTitle("Hello");

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.header_image);
        Palette.from(bmp).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getLightMutedSwatch().getRgb());
                collapsingToolbarLayout.setContentScrimColor(palette.getLightMutedSwatch().getRgb());
                collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
                collapsingToolbarLayout.setExpandedTitleColor(Color.BLACK);
            }
        });
    }


}
