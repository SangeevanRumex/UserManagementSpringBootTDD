package com.example.UserManagementSpringBoot.model.dto;

import com.example.UserManagementSpringBoot.model.Follows;

import java.util.Set;

public class UserDto {
    private int id;
    private String userName;
    private String city;
    private Set<Follows> follows;

    public UserDto() {
    }

    public UserDto(int id, String userName, String city, Set<Follows> follows) {
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

    public Set<Follows> getfollows() {
        return follows;
    }

    public void setfollows(Set<Follows> follows) {
        this.follows = follows;
    }
}
