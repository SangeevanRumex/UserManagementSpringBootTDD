package com.example.UserManagementSpringBoot.repository;

import com.example.UserManagementSpringBoot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query(value = "SELECT * FROM course WHERE deleted IS NOT TRUE", nativeQuery = true)
    List<Course> getCourses();

    @Query(value = "SELECT * FROM course WHERE id = :id AND deleted IS NOT TRUE", nativeQuery = true)
    Course getCourseById(@Param("id")int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE course SET deleted=TRUE WHERE id = :id", nativeQuery = true)
    void deleteCourse(@Param("id") int id);
}
