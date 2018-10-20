package com.bilalekrem.endpoints;

import com.google.gson.annotations.SerializedName;

public class AllData {
    @SerializedName("id")
    private long id;
    @SerializedName("ad_id")
    private long adId;
    @SerializedName("ad_title")
    private String title;
    @SerializedName("ad_description")
    private String description;
    @SerializedName("ad_call_to_action")
    private String callToAction;
    @SerializedName("ad_bid_price_kurus")
    private long bidPriceKurus;
    @SerializedName("ad_daily_budget_kurus")
    private long dailyBidgetKurus;
    @SerializedName("event_category")
    private String category;
    @SerializedName("event_type")
    private String eventType;

    @SerializedName("viewer_user_id")
    private long viewerUserId;
    @SerializedName("viewer_user_city")
    private String viewerAddressCityName;
    @SerializedName("viewer_education")
    private String viewerEducation;
    @SerializedName("viewer_job")
    private String viewerJob;
    @SerializedName("viewer_marital_status")
    private String  viewerMaritalStatus;
    @SerializedName("viewer_birt_year")
    private int viewerBirthdate;
    @SerializedName("viewer_gender")
    private String  viewerGender;

    private long creationDate;

    public long getId() {
        return id;
    }

    public long getAdId() {
        return adId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCallToAction() {
        return callToAction;
    }

    public long getBidPriceKurus() {
        return bidPriceKurus;
    }

    public long getDailyBidgetKurus() {
        return dailyBidgetKurus;
    }

    public String getCategory() {
        return category;
    }

    public String getEventType() {
        return eventType;
    }

    public long getViewerUserId() {
        return viewerUserId;
    }

    public String getViewerAddressCityName() {
        return viewerAddressCityName;
    }

    public String getViewerEducation() {
        return viewerEducation;
    }

    public String getViewerJob() {
        return viewerJob;
    }

    public String getViewerMaritalStatus() {
        return viewerMaritalStatus;
    }

    public int getViewerBirthdate() {
        return viewerBirthdate;
    }

    public String getViewerGender() {
        return viewerGender;
    }

    public long getCreationDate() {
        return creationDate;
    }
}