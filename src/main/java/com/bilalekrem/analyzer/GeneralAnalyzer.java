package com.bilalekrem.analyzer;

import com.bilalekrem.endpoints.Ad;
import com.bilalekrem.endpoints.AllData;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class GeneralAnalyzer {

    public static Stream<AllData> getAllDataByAdId(long id) {
        List<AllData> data = DataSource.getInstance().data();

        return data.stream().filter( d -> d.getAdId() == id);
    }

    public static Stream<AllData> getAllDataByAdId(long id, String eventType) {
        List<AllData> data = DataSource.getInstance().data();

        return data.stream().filter( d -> {
            if (d.getAdId() == id && d.getEventType() != null && d.getEventType().equals(eventType)) {
                return true;
            }
            return false;
        });
    }

    public static Stream<AllData> getAllDataByAdId(long id, int limit) {
        List<AllData> data = DataSource.getInstance().data();

        return data.stream().filter( d -> d.getAdId() == id).limit(limit);
    }

    public static Ad getAd(long id) {
        List<AllData> data = DataSource.getInstance().data();

        Optional<AllData> optData = data.stream().filter(d -> d.getAdId() == id).findFirst();
        if(optData.isPresent()) return new Ad(optData.get());
        return null;
    }


    public static Set<Ad> getAllAds() {
        List<AllData> data = DataSource.getInstance().data();

        Set<Ad> ads = new HashSet<>();
        for(AllData all: data) {
            ads.add(new Ad(all));
        }
        return ads;
    }

    public static Set<Ad> getAllAds(int limit) {
        List<AllData> data = DataSource.getInstance().data();

        Set<Ad> ads = new HashSet<>();
        for(AllData all: data) {
            ads.add(new Ad(all));
            if(ads.size() == limit) break;
        }
        return ads;
    }


    public static Set<Ad> getAdsByContainsTitle(String title) {
        List<AllData> data = DataSource.getInstance().data();
        Set<Ad> ads = new HashSet<>();
        data.stream().filter(d->{
            if(d.getTitle() != null && d.getTitle().contains(title)) {
                return true;
            }
            return false;
        }).forEach(d-> ads.add(new Ad(d)));
        return ads;
    }

    public static Set<Ad> getAdsByContainsDescription(String desc) {
        List<AllData> data = DataSource.getInstance().data();
        Set<Ad> ads = new HashSet<>();
        data.stream().filter(d->{
            if(d.getDescription() != null && d.getDescription().contains(desc)) {
                return true;
            }
            return false;
        }).forEach(d-> ads.add(new Ad(d)));
        return ads;
    }

    public static Set<Ad> getAdsByTitleAndDesc(String title, String desc) {
        List<AllData> data = DataSource.getInstance().data();
        Set<Ad> ads = new HashSet<>();
        data.stream().filter(d->{

            boolean titleFlag = (title.equals("") || (d.getTitle() != null && !d.getTitle().equals("") && d.getTitle().contains(title)));
            boolean descFlag = (desc.equals("") || (d.getDescription() != null && !d.getDescription().equals("") && d.getDescription().contains(desc)));

            return titleFlag && descFlag;
        }).forEach(d-> ads.add(new Ad(d)));
        return ads;
    }

    public static Set<Ad> getAdsByEventType(String eventType) {
        Set<Ad> ad= new HashSet<>();
        List<AllData> data = DataSource.getInstance().data();
        data.stream().filter( d -> {
            if(d.getEventType() != null && d.getEventType().equals(eventType)) {
                return true;
            }
            return false;
        }).forEach(d -> ad.add(new Ad(d)));
        return ad;
    }


}
