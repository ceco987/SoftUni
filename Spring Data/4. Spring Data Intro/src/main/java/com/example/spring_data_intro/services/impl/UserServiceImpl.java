package com.example.spring_data_intro.services.impl;

import com.example.spring_data_intro.entities.User;
import com.example.spring_data_intro.repositories.UserRepository;
import com.example.spring_data_intro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User register(User user) {
        return userRepo.save(user);
    }
}
