package com.example.hb.andapp;

import com.example.hb.responseutile.Posts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hb on 10/3/2015.
 */
public class ResponseTest {


    public <X> List<X> getListingData(String responseString, Class<X> c) {
//        Type t = new ParameterizedResponse(c);
        Type t = new TypeToken<List<Posts>>() {
        }.getType();

        List<X> t1 = new Gson().fromJson(responseString, t);
        return t1;
    }
}
