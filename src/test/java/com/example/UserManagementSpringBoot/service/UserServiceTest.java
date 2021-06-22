package com.example.UserManagementSpringBoot.service;

import com.example.UserManagementSpringBoot.mapper.UserMapper;
import com.example.UserManagementSpringBoot.model.User;
import com.example.UserManagementSpringBoot.model.dto.UserDto;
import com.example.UserManagementSpringBoot.repository.CourseRepository;
import com.example.UserManagementSpringBoot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.Assertions.*;

public class UserServiceTest {

    private UserRepository userRepository = Mockito.mock(UserRepository.class);
    private CourseRepository courseRepository = Mockito.mock(CourseRepository.class);
//    private UserMapper userMapper = Mockito.mock(UserMapper.class);
//    private ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
//    private User user = Mockito.mock(User.class);
//    private UserDto userDto = Mockito.mock(UserDto.class);

    @Test
    void testGetUserById() {
        ModelMapper modelMapper = new ModelMapper();
        UserMapper userMapper = new UserMapper(modelMapper);
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository,courseRepository,userMapper,modelMapper);
        User user = new User(1,"Sangee","Colombo",false,null);
        UserDto expectedUser = new UserDto(1,"Sangee","Colombo",null);
        Mockito.when(userRepository.getUserById(1)).thenReturn(user);

        UserDto responseUser = userServiceImpl.getUserById(1);

        assertThat(responseUser).isEqualToComparingFieldByFieldRecursively(expectedUser);
    }
}