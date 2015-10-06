package com.example.hb.adapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Car {

    @SerializedName("car_id")
    @Expose
    private String carId;
    @SerializedName("car_name")
    @Expose
    private String carName;


    /**
     * @return The carId
     */
    public String getCarId() {
        return carId;
    }

    /**
     * @param carId The car_id
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * @return The carName
     */
    public String getCarName() {
        return carName;
    }

    /**
     * @param carName The car_name
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }


}