package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.mapper.CourseMapper;
import com.example.UserManagementSpringBoot.model.Course;
import com.example.UserManagementSpringBoot.model.dto.CourseDto;
import com.example.UserManagementSpringBoot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public boolean addCourse(CourseDto courseDto) {
        courseRepository.save(courseMapper.convertFromDto(courseDto));
        return true;
    }

    @Override
    public boolean updateCourse(CourseDto courseDto) {
        Course oldCourse = courseRepository.getCourseById(courseDto.getId());
        if(oldCourse!=null){
            courseRepository.save(courseMapper.convertFromDto(courseDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourse(int id) {
        Course oldCourse = courseRepository.getCourseById(id);
        if(oldCourse!=null) {
            courseRepository.deleteCourse(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> courses = courseRepository.getCourses();
        return courses.stream().map(courseMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(int id) {
        Course oldCourse = courseRepository.getCourseById(id);
        if(oldCourse!=null) {
            return courseMapper.convertToDto(courseRepository.getCourseById(id));
        }
        return null;
    }
}
