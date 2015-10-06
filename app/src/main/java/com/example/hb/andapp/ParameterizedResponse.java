package com.example.hb.andapp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by hb on 10/3/2015.
 */
public class ParameterizedResponse<T> implements ParameterizedType {
    public Class<?> type;

    public ParameterizedResponse(Class<T> type) {
        this.type = type;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[]{this.type};
    }


    @Override
    public Type getOwnerType() {
        return List.class;
    }


    @Override
    public Type getRawType() {
        return null;
    }
}
