package com.bilalekrem.endpoints;

import java.util.Objects;

public class Ad {

    private long id;
    private String title;
    private String description;
    private String callToAction;
    private long bidPriceKurus;
    private long dailyBidgetKurus;

    public Ad(AllData allData) {
        id = allData.getAdId();
        title = allData.getTitle();
        description = allData.getDescription();
        callToAction = allData.getCallToAction();
        bidPriceKurus = allData.getBidPriceKurus();
        dailyBidgetKurus = allData.getDailyBidgetKurus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String str="";
        // to fit into screen, do not show whole string
        if(title != null && !title.isEmpty()) {
            str += title.substring(0, 10 < title.length() - 1 ? 10 : title.length() - 1);
        }
        str += "-------";
        if(description != null && !description.isEmpty()) {
            str += description.substring(0, 10 < description.length() - 1 ? 10 : description.length() - 1);
        }
        return str;
    }

    public long getId() {
        return id;
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
}
