package com.example.UserManagementSpringBoot.repository;

import com.example.UserManagementSpringBoot.model.Course;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;

    Course course = new Course(1,"Java",1000,false);

    @Test
    @BeforeAll
    void save(){
        Course savedCourse = courseRepository.save(course);
        assertThat(savedCourse).usingRecursiveComparison().ignoringFields("id","deleted").isEqualTo(course);
    }

    @Test
    void getCourseById(){
        Course gotCourse = courseRepository.getCourseById(1);
        assertThat(gotCourse).usingRecursiveComparison().ignoringFields("id","deleted").isEqualTo(course);
    }

    @Test
    @AfterAll
    void deleteCourse(){
        courseRepository.deleteCourse(1);
        Course gotCourse = courseRepository.getCourseById(1);
        assertThat(gotCourse).usingRecursiveComparison().ignoringFields("id","deleted").isEqualTo(null);
    }
}