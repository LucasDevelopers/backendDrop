package com.fxdrop.fxdropapi.controller;

import com.fxdrop.fxdropapi.dto.CreateUserDto;
import com.fxdrop.fxdropapi.dto.LoginDto;
import com.fxdrop.fxdropapi.dto.UserDto;
import com.fxdrop.fxdropapi.exception.LoginException;
import com.fxdrop.fxdropapi.model.User;
import com.fxdrop.fxdropapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUser(){
        return userService.listAllUser();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginRequest) {
        try {
            User user = userService.login(loginRequest.getCredential(), loginRequest.getPassword());
            return ResponseEntity.ok(user);
        } catch (LoginException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
    }

}
