package com.bilalekrem.analyzer;

import com.bilalekrem.endpoints.AllData;
import com.bilalekrem.endpoints.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdAnalyzer {

    private List<AllData> data;
    public AdAnalyzer(Stream<AllData> data) {
        this.data = data.collect(Collectors.toList());
    }

    public static long howManyAdCanBeListPerDay(long adId) {
        Optional<AllData> ad = GeneralAnalyzer.getAllDataByAdId(adId,1).findFirst();
        if(ad.isPresent()) {
            return ad.get().getDailyBidgetKurus() / ad.get().getBidPriceKurus();
        }else {
            return -1;
        }
    }

    public Set<User> getUsers() {
        Set<User> s = new HashSet<>();
        data.forEach(d -> s.add(new User(d)));
        return s;
    }

    public Set<User> getUsersByGender(String gender) {
        Set<User> s = new HashSet<>();
        data.stream().filter(d -> d.getViewerGender().equals(gender)).forEach(d -> {
            s.add(new User(d));
        });
        return s;
    }

    public Set<String> getJobs() {
        Set<User> users = getUsers();
        Set<String> jobs = new HashSet<>();
        for (User u: users) {
            if(u.getJob() != null && !u.getJob().equals("")) {
                jobs.add(u.getJob());
            }
        }
        return jobs;
    }

    public Set<String> getCities() {
        Set<User> users = getUsers();
        Set<String> cities = new HashSet<>();
        for (User u: users) {
            if(u.getCityName() != null && !u.getCityName().equals("")) {
                cities.add(u.getCityName());
            }
        }
        return cities;
    }

    public Set<String> getEducations() {
        Set<User> users = getUsers();
        Set<String> educations = new HashSet<>();
        for (User u: users) {
            if(u.getEducation() != null && !u.getEducation().equals("")) {
                educations.add(u.getEducation());
            }
        }
        return educations;
    }

    public Set<Integer> getAgesByAdId() {
        Set<User> users = getUsers();
        Set<Integer> ages = new HashSet<>();
        for (User u: users) {
            if(u.getAge() != 0) {
                ages.add(u.getAge());
            }
        }
        return ages;
    }

    private Set<User> getUsersByEventType(String eventType) {
        Set<User> users = new HashSet<>();
        data.stream().filter( d -> {
            if(d.getEventType() != null && d.getEventType().equals(eventType)) {
                return true;
            }
            return false;
        }).forEach(d -> users.add(new User(d)));
        return users;
    }

    public Set<User> getUsersDidNotClick() {
        return getUsersByEventType("IMPRESSION");
    }

    public Set<User> getUsersClicked() {
        return getUsersByEventType("CLICK");
    }

    public Map<User, Integer> getUserFreq() {
        Map<User, Integer> freq = new HashMap<>();
        data.forEach(d -> {
            User user = new User(d);
            Integer count = freq.get(user);
            if(count == null) {
                count = 0;
            }
            count++;
            freq.put(user, count);
        });
        return freq;
    }

    public Map<String, Integer> getCityFreq() {
        Map<String, Integer> freq = new HashMap<>();
        data.forEach(d -> {
            String entry = d.getViewerAddressCityName();
            if(entry == null) return;

            Integer count = freq.get(entry);
            if(count == null) {
                count = 0;
            }
            count++;
            freq.put(entry, count);
        });
        return freq;
    }

    public Map<String, Integer> getJobFreq() {
        Map<String, Integer> freq = new HashMap<>();
        data.forEach(d -> {
            String entry = d.getViewerJob();
            if(entry == null) return;

            Integer count = freq.get(entry);
            if(count == null) {
                count = 0;
            }
            count++;
            freq.put(entry, count);
        });
        return freq;
    }

    public Map<Integer, Integer> getAgeFreq() {
        Map<Integer, Integer> freq = new HashMap<>();
        data.forEach(d -> {
            int entry = d.getViewerBirthdate();
            if(entry == 0) return;

            Integer count = freq.get(entry);
            if(count == null) {
                count = 0;
            }
            count++;
            freq.put(entry, count);
        });
        return freq;
    }


}
