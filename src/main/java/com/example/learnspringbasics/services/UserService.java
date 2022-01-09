package com.example.learnspringbasics.services;

import com.example.learnspringbasics.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User create(User user);

    void deleteById(Long id);
}
