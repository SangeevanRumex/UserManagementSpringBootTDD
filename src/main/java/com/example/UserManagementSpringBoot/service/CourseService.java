package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.model.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    boolean addCourse(CourseDto courseDto);
    boolean updateCourse(CourseDto courseDto);
    boolean deleteCourse(int id);
    List<CourseDto> getCourses();
    CourseDto getCourseById(int id);
}
