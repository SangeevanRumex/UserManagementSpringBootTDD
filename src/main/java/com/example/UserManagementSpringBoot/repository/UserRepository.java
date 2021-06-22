package com.example.UserManagementSpringBoot.repository;

import com.example.UserManagementSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user WHERE deleted IS NOT TRUE", nativeQuery = true)
    List<User> getUsers();

    @Query(value = "SELECT * FROM user WHERE id = :id AND deleted IS NOT TRUE", nativeQuery = true)
    User getUserById(@Param("id")int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user SET deleted=TRUE WHERE id = :id", nativeQuery = true)
    void deleteUser(@Param("id") int id);

}
