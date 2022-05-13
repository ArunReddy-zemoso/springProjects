package com.springboot.library.service;

import com.springboot.library.entity.User;
import com.springboot.library.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {
    @MockBean
    UserRepository userRepository;

    @Test
    void TestfindAll() {
        when(userRepository.findAll()).thenReturn(Stream.of(new User(1,"arun","arun","ROLE_STUDENT")).collect(Collectors.toList()));
        assertEquals(1,userRepository.findAll().size());
    }

    @Test
    void findById() {
        User user = new User(1,"arun","arun","ROLE_STUDENT");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        assertEquals(Optional.of(user),userRepository.findById(1));
    }

    @Test
    void save() {
        User user = new User(1,"arun","arun","ROLE_STUDENT");
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userRepository.save(user));
    }

    @Test
    void deleteById() {
        User user = new User(1,"arun","arun","ROLE_STUDENT");
        userRepository.deleteById(1);
        verify(userRepository,times(1)).deleteById(1);
    }

    @Test
    void deleteByUsername() {
        User user = new User(1,"arun","arun","ROLE_STUDENT");
        userRepository.deleteByUsername("arun");
        verify(userRepository,times(1)).deleteByUsername("arun");
    }
}