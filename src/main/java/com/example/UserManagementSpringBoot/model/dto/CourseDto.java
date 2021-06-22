package com.example.UserManagementSpringBoot.model.dto;

public class CourseDto {
    private int id;

    public CourseDto() {
    }

    public CourseDto(int id, String courseName, int fee) {
        this.id = id;
        this.courseName = courseName;
        this.fee = fee;
    }

    private String courseName;
    private int fee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
