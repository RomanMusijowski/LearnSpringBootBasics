package com.example.learnspringbasics.controllers;

import com.example.learnspringbasics.entity.User;
import com.example.learnspringbasics.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    public static final String BASE_PATH = "/api/user";

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    protected ObjectMapper objectMapper;

    private User user;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }


    @Test
    void getById() throws Exception {
        //prepare data
        user = userRepository.saveAndFlush(new User("username1", "pass1", "email1", "name1", "last1"));

        //execute
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.get(BASE_PATH + "/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON));

        //check the result
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("username").value(user.getUsername()))
                .andExpect(jsonPath("password").value(user.getPassword()))
                .andExpect(jsonPath("email").value(user.getEmail()))
                .andExpect(jsonPath("firstName").value(user.getFirstName()))
                .andExpect(jsonPath("lastName").value(user.getLastName()));
    }

    @Test
    void create() throws Exception {
        //prepare data
        User user = new User("username", "pass", "email", "name", "last");

        //execute
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.post(BASE_PATH)
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON));

        //check the result
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").value(user.getUsername()))
                .andExpect(jsonPath("password").value(user.getPassword()))
                .andExpect(jsonPath("email").value(user.getEmail()))
                .andExpect(jsonPath("firstName").value(user.getFirstName()))
                .andExpect(jsonPath("lastName").value(user.getLastName()));
    }
}