package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User register (User user);
}
