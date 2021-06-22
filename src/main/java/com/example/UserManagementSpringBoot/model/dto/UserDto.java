package com.example.UserManagementSpringBoot.model.dto;

import java.util.Set;

public class UserDto {
    private int id;
    private String userName;
    private String city;
    private Set<CourseDto> followedCourses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<CourseDto> getFollowedCourses() {
        return followedCourses;
    }

    public void setFollowedCourses(Set<CourseDto> followedCourses) {
        this.followedCourses = followedCourses;
    }
}
