package com.example.UserManagementSpringBoot.repository;

import com.example.UserManagementSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.deleted IS NOT TRUE")
    List<User> getUsers();

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.deleted IS NOT TRUE")
    User getUserById(@Param("id")int id);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.deleted=TRUE WHERE u.id = :id")
    void deleteUser(@Param("id") int id);
}
