package com.fxdrop.fxdropapi.service;

import org.springframework.stereotype.Service;
import com.fxdrop.fxdropapi.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> usuarios = new ArrayList<>();

    public User createUser(User user) {
        usuarios.add(user);
        return user;
    }

    public List<User> listUser() {
        return usuarios;
    }

}
