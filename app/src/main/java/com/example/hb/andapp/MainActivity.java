package com.example.hb.andapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hb.responseutile.Posts;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    String url = "http://www.carsapp.co.za/ws/user/find_car";
    String url2 = "http://54.169.227.21/WS/post_listing?city_name=Ahmedabad&accesstoken=%7BFABD6AF8-1397-CAD0-C138-B030C948F965%7D&search_keyword=&device_width=xhdpi&no_of_records=&user_id=4757&sort_type=&need_invited_user=No&city_id=1&category_id=1&last_access_date=&need_notification_count=No&page_index=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        ActionBar actionBar = getSupportActionBar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.ab_tool);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        setSupportActionBar(toolbar);
        listView = (ListView) findViewById(R.id.ListView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ws_menu, menu);
        return true;
    }

    ProgressDialog pd;

    private void strRequest() {
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("strRequest Response", "" + response);
                try {
                    setAdapter(new JSONArray(response));
                    if (pd != null && pd.isShowing()) {
                        pd.dismiss();
                    }

                } catch (JSONException e) {
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("", "");
            }
        });
        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait...str Request");
        pd.show();
        Volley.newRequestQueue(this).add(stringRequest1);
    }

    private void pogoRequest() {
        WSGsonTest wsGsonTest = new WSGsonTest(Request.Method.GET, url2, Posts.class, new Response.Listener() {
            @Override
            public void onResponse(Object response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(wsGsonTest);
    }


    private void jsonRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                setAdapter(response);
                if (pd != null && pd.isShowing())
                    pd.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait...json Request");
        pd.show();
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.strRequest:
                strRequest();
                return true;
            case R.id.jsonRequest:
                jsonRequest();
                return true;
            case R.id.pojoRequest:
                pogoRequest();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setAdapter(JSONArray json) {
        try {
            if (json != null && json.length() > 0) {
                ListAdpt adapter = new ListAdpt(MainActivity.this,
                        json);
                listView.setAdapter(adapter);
            }
        } catch (Exception e) {
        }
    }

    public class ListAdpt extends BaseAdapter {

        private Context context;
        private JSONArray jsonArray;
        private DisplayImageOptions options;

        public ListAdpt(Context context, JSONArray jsonArray) {
            this.context = context;
            this.jsonArray = jsonArray;
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.ic_launcher)
                    .showImageForEmptyUri(R.drawable.ic_launcher)
                    .showImageOnFail(R.drawable.ic_launcher)
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .build();
        }

        @Override
        public int getCount() {
            return jsonArray.length();
        }

        @Override
        public JSONObject getItem(int position) {
            try {
                return jsonArray.getJSONObject(position);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder {
            ImageView img1, img2, img3, img4, img5, imgCar;
            TextView txtCar;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(
                        R.layout.list_item, parent, false);
                vHolder = new ViewHolder();
                vHolder.imgCar = (ImageView) convertView
                        .findViewById(R.id.imgCar);
                vHolder.txtCar = (TextView) convertView
                        .findViewById(R.id.txtCar);
//                vHolder.img2 = (ImageView) convertView
//                        .findViewById(R.id.progressive_jpeg2);
//                vHolder.img3 = (ImageView) convertView
//                        .findViewById(R.id.progressive_jpeg3);
//                vHolder.img4 = (ImageView) convertView
//                        .findViewById(R.id.progressive_jpeg4);
//                vHolder.img5 = (ImageView) convertView
//                        .findViewById(R.id.progressive_jpeg5);
                convertView.setTag(vHolder);

            } else {
                vHolder = (ViewHolder) convertView.getTag();
            }
            try {
                vHolder.txtCar.setText(getItem(position).getString("car_name"));
                ImageLoader.getInstance().displayImage(getItem(position).getString("car_image"), vHolder.imgCar, options);
//                ImageLoader.getInstance().displayImage(getItem(position).getString("m_image"), vHolder.img1, options);
//                ImageLoader.getInstance().displayImage(getItem(position).getString("m_image"), vHolder.img2, options);
//                ImageLoader.getInstance().displayImage(getItem(position).getString("m_image"), vHolder.img3, options);
//                ImageLoader.getInstance().displayImage(getItem(position).getString("m_image"), vHolder.img4, options);
//                ImageLoader.getInstance().displayImage(getItem(position).getString("m_image"), vHolder.img5, options);
//                Glide.with(MainActivity.this)
//                        .load(getItem(position).getString("image_path1"))
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(vHolder.img1);
//                Glide.with(MainActivity.this)
//                        .load(getItem(position).getString("image_path2"))
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(vHolder.img2);
//                Glide.with(MainActivity.this)
//                        .load(getItem(position).getString("image_path3"))
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(vHolder.img3);
//                Glide.with(MainActivity.this)
//                        .load(getItem(position).getString("image_path4"))
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(vHolder.img4);
//                Glide.with(MainActivity.this)
//                        .load(getItem(position).getString("image_path5"))
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(vHolder.img5);
//                Picasso.with(MainActivity.this).load(getItem(position).getString("image_path1")).into(vHolder.img1);
//                Picasso.with(MainActivity.this).load(getItem(position).getString("image_path2")).into(vHolder.img2);
//                Picasso.with(MainActivity.this).load(getItem(position).getString("image_path3")).into(vHolder.img3);
//                Picasso.with(MainActivity.this).load(getItem(position).getString("image_path4")).into(vHolder.img4);
//                Picasso.with(MainActivity.this).load(getItem(position).getString("image_path5")).into(vHolder.img5);
            } catch (JSONException e) {
            }
            return convertView;
        }

    }


}
