package com.example.hb.responseutile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hb on 10/3/2015.
 */
public class GetNoOfUser {

    @SerializedName("no_of_users")
    @Expose
    private String noOfUsers;
    @SerializedName("InternalMobileAppVersion")
    @Expose
    private String InternalMobileAppVersion;
    @SerializedName("notification_count")
    @Expose
    private String notificationCount;
    @SerializedName("InternalMobileAppVersionMessage")
    @Expose
    private String InternalMobileAppVersionMessage;
    @SerializedName("total_invited_count")
    @Expose
    private String totalInvitedCount;
    @SerializedName("total_registered_count")
    @Expose
    private String totalRegisteredCount;

    /**
     * @return The noOfUsers
     */
    public String getNoOfUsers() {
        return noOfUsers;
    }

    /**
     * @param noOfUsers The no_of_users
     */
    public void setNoOfUsers(String noOfUsers) {
        this.noOfUsers = noOfUsers;
    }

    /**
     * @return The InternalMobileAppVersion
     */
    public String getInternalMobileAppVersion() {
        return InternalMobileAppVersion;
    }

    /**
     * @param InternalMobileAppVersion The InternalMobileAppVersion
     */
    public void setInternalMobileAppVersion(String InternalMobileAppVersion) {
        this.InternalMobileAppVersion = InternalMobileAppVersion;
    }

    /**
     * @return The notificationCount
     */
    public String getNotificationCount() {
        return notificationCount;
    }

    /**
     * @param notificationCount The notification_count
     */
    public void setNotificationCount(String notificationCount) {
        this.notificationCount = notificationCount;
    }

    /**
     * @return The InternalMobileAppVersionMessage
     */
    public String getInternalMobileAppVersionMessage() {
        return InternalMobileAppVersionMessage;
    }

    /**
     * @param InternalMobileAppVersionMessage The InternalMobileAppVersionMessage
     */
    public void setInternalMobileAppVersionMessage(String InternalMobileAppVersionMessage) {
        this.InternalMobileAppVersionMessage = InternalMobileAppVersionMessage;
    }

    /**
     * @return The totalInvitedCount
     */
    public String getTotalInvitedCount() {
        return totalInvitedCount;
    }

    /**
     * @param totalInvitedCount The total_invited_count
     */
    public void setTotalInvitedCount(String totalInvitedCount) {
        this.totalInvitedCount = totalInvitedCount;
    }

    /**
     * @return The totalRegisteredCount
     */
    public String getTotalRegisteredCount() {
        return totalRegisteredCount;
    }

    /**
     * @param totalRegisteredCount The total_registered_count
     */
    public void setTotalRegisteredCount(String totalRegisteredCount) {
        this.totalRegisteredCount = totalRegisteredCount;
    }

}
