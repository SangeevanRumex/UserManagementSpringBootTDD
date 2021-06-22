package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.model.dto.CourseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

public class CourseServiceTests {
    @Autowired
    CourseService courseService;

//    public class Dog {
//        private String name;
//        private Float weight;
//
//        public Dog(String fido, double v) {
//        }
//
//        // standard getters and setters
//    }
//
//    Dog fido = new Dog("Fido", 5.25);
//
//    Dog fidosClone = new Dog("Fido", 5.25);
//
//    @Test
//    public void addCourse() {
//        assertThat(fido).isEqualTo(fidosClone);
//    }

    @Test
    public void getCourseById() {
        CourseDto testCourse = new CourseDto(4,"ReactJs",1000);
        CourseDto responseCourse = new CourseDto(4,"ReactJs",1000);
        assertThat(responseCourse).isEqualToComparingFieldByFieldRecursively(testCourse);
    }
}
