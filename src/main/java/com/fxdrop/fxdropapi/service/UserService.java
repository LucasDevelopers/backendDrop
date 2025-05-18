package com.fxdrop.fxdropapi.service;

import com.fxdrop.fxdropapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fxdrop.fxdropapi.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listUser() {
        return userRepository.findAll();
    }

}
