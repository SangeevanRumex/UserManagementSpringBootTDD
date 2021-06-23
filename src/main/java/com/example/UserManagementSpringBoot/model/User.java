package com.example.UserManagementSpringBoot.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String city;
    private boolean deleted;
    @OneToMany(targetEntity = Follows.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Follows> follows = new HashSet<>();

    public void followCourse(Follows follow){
        follows.add(follow);
    }

    public User() {
    }

    public User(int id, String userName, String city, boolean deleted, Set<Follows> follows) {
        this.id = id;
        this.userName = userName;
        this.city = city;
        this.deleted = deleted;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Set<Follows> getFollows() {
        return follows;
    }

    public void setFollows(Set<Follows> follows) {
        this.follows = follows;
    }
}
