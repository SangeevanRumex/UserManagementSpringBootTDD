package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    boolean addUser(UserDto userDto);
    boolean updateUser(UserDto userDto);
    boolean deleteUser(int id);
    List<UserDto> getUsers();
    UserDto getUserById(int id);
    boolean followCourse(int userId, int courseId);
}
