package com.example.UserManagementSpringBoot.repository;

import com.example.UserManagementSpringBoot.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    User user = new User(1,"Sangeevan","Colombo",false,null);

    @Test
    @BeforeAll
    void save(){
        User savedUser = userRepository.save(user);
        assertThat(savedUser).usingRecursiveComparison().ignoringFields("id","deleted","follows").isEqualTo(user);
    }

    @Test
    void getUserById(){
        int id = userRepository.getUsers().get(0).getId();
        User gotUser = userRepository.getUserById(id);
        assertThat(gotUser).usingRecursiveComparison().ignoringFields("id","deleted","follows").isEqualTo(user);
    }

    @Test
    void getUsers(){
        List<User> gotUsers = userRepository.getUsers();
        assertThat(gotUsers.get(0)).usingRecursiveComparison().ignoringFields("id","deleted","follows").isEqualTo(user);
    }

    @Test
    @AfterAll
    void deleteUser(){
        int id = userRepository.getUsers().get(0).getId();
        userRepository.deleteUser(id);
        User gotUser = userRepository.getUserById(id);
        assertThat(gotUser).usingRecursiveComparison().ignoringFields("id","deleted","follows").isEqualTo(null);
    }
}