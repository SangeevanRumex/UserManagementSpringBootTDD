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

    @ManyToMany(targetEntity = Course.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_follow",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private Set<Course> followedCourses = new HashSet<>();

    public void followCourse(Course course){
        followedCourses.add(course);
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

    public Set<Course> getFollowedCourses() {
        return followedCourses;
    }

    public void setFollowedCourses(Set<Course> followedCourses) {
        this.followedCourses = followedCourses;
    }
}
