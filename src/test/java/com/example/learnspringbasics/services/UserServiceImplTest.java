package com.example.learnspringbasics.services;

import com.example.learnspringbasics.entity.User;
import com.example.learnspringbasics.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    private User user;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void getById() {
        //given
        user = userRepository.saveAndFlush(new User("username", "pass", "email", "name", "last"));

        //when
        when(userRepository.getById(anyLong())).thenReturn(user);

        User result = userService.getById(this.user.getId());

        //check the result
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getId()).isEqualTo(user.getId());
        assertThat(result.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void create() {
        //given
        user = userRepository.saveAndFlush(new User("username2", "pass2", "email2", "name2", "last2"));

        //when
        when(userRepository.save(any())).thenReturn(user);
        User result = userService.create(this.user);

        //check the result
        assertThat(result.getEmail()).isEqualTo(user.getEmail());
        assertThat(result.getId()).isEqualTo(user.getId());
        assertThat(result.getPassword()).isEqualTo(user.getPassword());
    }
}