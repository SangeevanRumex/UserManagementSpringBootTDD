package com.example.UserManagementSpringBoot.model.dto;

public class FollowsDto {
    private CourseDto course;

    public FollowsDto() {
    }

    public FollowsDto(CourseDto course) {
        this.course = course;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }
}
