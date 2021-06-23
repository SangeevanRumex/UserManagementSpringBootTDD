package com.example.UserManagementSpringBoot.repository;

import com.example.UserManagementSpringBoot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("SELECT c FROM Course c WHERE c.deleted IS NOT TRUE")
    List<Course> getCourses();

    @Query("SELECT c FROM Course c WHERE c.id = :id AND c.deleted IS NOT TRUE")
    Course getCourseById(@Param("id")int id);

    @Transactional
    @Modifying
    @Query("UPDATE Course c SET c.deleted=TRUE WHERE c.id = :id")
    void deleteCourse(@Param("id") int id);
}
