package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.mapper.UserMapper;
import com.example.UserManagementSpringBoot.model.Course;
import com.example.UserManagementSpringBoot.model.Follows;
import com.example.UserManagementSpringBoot.model.User;
import com.example.UserManagementSpringBoot.model.dto.UserDto;
import com.example.UserManagementSpringBoot.repository.CourseRepository;
import com.example.UserManagementSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, CourseRepository courseRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean addUser(UserDto userDto){
        userRepository.save(userMapper.convertFromDto(userDto));
        return true;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        User oldUser = userRepository.getUserById(userDto.getId());
        if(oldUser!=null){
            userRepository.save(userMapper.convertFromDto(userDto));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        User oldUser = userRepository.getUserById(id);
        if(oldUser!=null) {
            userRepository.deleteUser(id);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.getUsers();
        return users.stream().map(userMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {
        User oldUser = userRepository.getUserById(id);
        if(oldUser!=null) {
            return userMapper.convertToDto(userRepository.getUserById(id));
        }
        return null;
    }

    @Override
    public boolean followCourse(int userId, int courseId) {
        User oldUser = userRepository.getUserById(userId);
        Course oldCourse = courseRepository.getCourseById(courseId);
        Follows follow = new Follows(oldUser,oldCourse);
        oldUser.followCourse(follow);
        if(oldUser!=null && oldCourse!=null){
            userRepository.save(oldUser);
            return true;
        }
        return false;
    }
}
