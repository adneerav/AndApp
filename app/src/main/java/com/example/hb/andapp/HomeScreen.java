package com.example.hb.andapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * Created by hb on 9/15/2015.
 */
public class HomeScreen extends BaseFragment {
    public static final String TAG = "HomeScreen";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_screen, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btnSelect).setOnClickListener(new View.OnClickListener() {
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
