package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.mapper.CourseMapper;
import com.example.UserManagementSpringBoot.model.Course;
import com.example.UserManagementSpringBoot.model.dto.CourseDto;
import com.example.UserManagementSpringBoot.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.assertThat;

class CourseServiceTest {

    private CourseRepository courseRepository = Mockito.mock(CourseRepository.class);

    ModelMapper modelMapper = new ModelMapper();
    CourseMapper courseMapper = new CourseMapper(modelMapper);

    CourseServiceImpl courseServiceImpl = new CourseServiceImpl(courseRepository,courseMapper);

    @Test
    void getCourseById() {
        Course requestedCourse = new Course(1,"Java",1000,false);
        CourseDto expectedCourse = new CourseDto(1,"Java",1000);
        Mockito.when(courseRepository.getCourseById(1)).thenReturn(requestedCourse);
        CourseDto responseCourse = courseServiceImpl.getCourseById(1);

        assertThat(responseCourse).isEqualToComparingFieldByFieldRecursively(expectedCourse);
    }
}