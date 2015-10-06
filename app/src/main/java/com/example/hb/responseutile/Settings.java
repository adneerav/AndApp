package com.example.hb.responseutile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Settings {

    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("curr_page")
    @Expose
    private String currPage;
    @SerializedName("prev_page")
    @Expose
    private String prevPage;
    @SerializedName("next_page")
    @Expose
    private String nextPage;
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("current_time")
    @Expose
    private String currentTime;

    /**
     * @return The count
     */
    public String getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * @return The currPage
     */
    public String getCurrPage() {
        return currPage;
    }

    /**
     * @param currPage The curr_page
     */
    public void setCurrPage(String currPage) {
        this.currPage = currPage;
    }

    /**
     * @return The prevPage
     */
    public String getPrevPage() {
        return prevPage;
    }

    /**
     * @param prevPage The prev_page
     */
    public void setPrevPage(String prevPage) {
        this.prevPage = prevPage;
    }

    /**
     * @return The nextPage
     */
    public String getNextPage() {
        return nextPage;
    }

    /**
     * @param nextPage The next_page
     */
    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @return The success
     */
    public String getSuccess() {
        return success;
    }

    /**
     * @param success The success
     */
    public void setSuccess(String success) {
        this.success = success;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The currentTime
     */
    public String getCurrentTime() {
        return currentTime;
    }

    /**
     * @param currentTime The current_time
     */
    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

}
