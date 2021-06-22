package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.model.Course;
import com.example.UserManagementSpringBoot.model.User;
import com.example.UserManagementSpringBoot.model.dto.UserDto;
import com.example.UserManagementSpringBoot.repository.CourseRepository;
import com.example.UserManagementSpringBoot.repository.UserRepository;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Override
    public boolean addUser(UserDto userDto){
        userRepository.save(convertFromDto(userDto));
        return true;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        User oldUser = userRepository.getUserById(userDto.getId());
        if(oldUser!=null){
            userRepository.save(convertFromDto(userDto));
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
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(int id) {
        User oldUser = userRepository.getUserById(id);
        if(oldUser!=null) {
            return convertToDto(userRepository.getUserById(id));
        }
        return null;
    }

    @Override
    public boolean followCourse(int userId, int courseId) {
        User oldUser = userRepository.getUserById(userId);
        Course oldCourse = courseRepository.getCourseById(courseId);
        oldUser.followCourse(oldCourse);
        if(oldUser!=null && oldCourse!=null){
            userRepository.save(oldUser);
            return true;
        }
        return false;
    }

    public UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public User convertFromDto(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
