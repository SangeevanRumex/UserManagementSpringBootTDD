package com.example.UserManagementSpringBoot.mapper;

import com.example.UserManagementSpringBoot.model.User;
import com.example.UserManagementSpringBoot.model.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserMapper() {
    }

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDto convertToDto(User user)
    {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public User convertFromDto(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
