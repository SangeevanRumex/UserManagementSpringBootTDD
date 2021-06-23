package com.example.UserManagementSpringBoot.model.dto;

import com.example.UserManagementSpringBoot.model.Follows;

import java.util.Set;

public class UserDto {
    private int id;
    private String userName;
    private String city;
    private Set<FollowsDto> follows;

    public UserDto() {
    }

    public UserDto(int id, String userName, String city, Set<FollowsDto> follows) {
        this.id = id;
        this.userName = userName;
        this.city = city;
        this.follows = follows;
    }

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

    public Set<FollowsDto> getfollows() {
        return follows;
    }

    public void setfollows(Set<FollowsDto> follows) {
        this.follows = follows;
    }
}
