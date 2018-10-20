package com.bilalekrem.endpoints;

import java.util.Objects;

public class User {

    private long id;
    private int age;
    private String cityName;
    private String education;
    private String job;
    private String gender;
    private String maritalStatus;

    public User(AllData data) {
        id = data.getViewerUserId();
        age = data.getViewerBirthdate();
        cityName = data.getViewerAddressCityName();
        education = data.getViewerEducation();
        job = data.getViewerJob();
        gender = data.getViewerGender();
        maritalStatus = data.getViewerMaritalStatus();
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCityName() {
        return cityName;
    }

    public String getEducation() {
        return education;
    }

    public String getJob() {
        return job;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
