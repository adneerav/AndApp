package com.example.hb.tooltest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.hb.andapp.BaseFragment;
import com.example.hb.andapp.R;

/**
 * Created by hb on 9/15/2015.
 */
public class HomeScreenT extends BaseFragmentT {
    public static final String TAG = "HomeScreenT";
    private View v;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (v != null) return v;
        return inflater.inflate(R.layout.home_screen_t, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ScreenCustom screenCustom = (ScreenCustom) getActivity();
        v = view;
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        Toolbar tool = (Toolbar) v.findViewById(R.id.ab_tool);
        tool.setPadding(0, screenCustom.getStatusBarHeight(), 0, 0);
        tool.setTitle(TAG);
        v.setPadding(0, 0, 0, screenCustom.getNavigationBarHeight());
        screenCustom.setSupportActionBar(tool);
        v.findViewById(R.id.btnSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (searchView != null) {
                    Toast.makeText(getActivity(), "Search View getQuery()== getText() > " + searchView.getQuery(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_home_screen, menu);
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem menuItemCompat = menu.findItem(R.id.search_view);
        searchView = (SearchView) menuItemCompat.getActionView();
        searchView.setQueryHint("Edit Text QueryHint()");
    }

    SearchView searchView;
}
