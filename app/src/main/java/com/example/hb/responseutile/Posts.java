package com.example.hb.responseutile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Posts extends Settings {

    @SerializedName("get_post_details")
    @Expose
    private List<GetPostDetail> getPostDetails = new ArrayList<GetPostDetail>();
    @SerializedName("get_no_of_users")
    @Expose
    private List<GetNoOfUser> getNoOfUsers = new ArrayList<GetNoOfUser>();
    @SerializedName("random_contact")
    @Expose
    private List<Object> randomContact = new ArrayList<Object>();

    /**
     * @return The getPostDetails
     */
    public List<GetPostDetail> getGetPostDetails() {
        return getPostDetails;
    }

    /**
     * @param getPostDetails The get_post_details
     */
    public void setGetPostDetails(List<GetPostDetail> getPostDetails) {
        this.getPostDetails = getPostDetails;
    }

    /**
     * @return The getNoOfUsers
     */
    public List<GetNoOfUser> getGetNoOfUsers() {
        return getNoOfUsers;
    }

    /**
     * @param getNoOfUsers The get_no_of_users
     */
    public void setGetNoOfUsers(List<GetNoOfUser> getNoOfUsers) {
        this.getNoOfUsers = getNoOfUsers;
    }

    /**
     * @return The randomContact
     */
    public List<Object> getRandomContact() {
        return randomContact;
    }

    /**
     * @param randomContact The random_contact
     */
    public void setRandomContact(List<Object> randomContact) {
        this.randomContact = randomContact;
    }

}

