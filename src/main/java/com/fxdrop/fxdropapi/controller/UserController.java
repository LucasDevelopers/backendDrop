package com.fxdrop.fxdropapi.controller;

import com.fxdrop.fxdropapi.dto.userDto.*;
import com.fxdrop.fxdropapi.exception.LoginException;
import com.fxdrop.fxdropapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public Page<UserDto> getAllUser(Pageable pagination){
        return userService.listAllUser(pagination);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginRequest) {
        try {
            UserDto userDto = userService.login(loginRequest.credential(), loginRequest.password());
            return ResponseEntity.ok(userDto);
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

    @PutMapping("/update-user")
    @Transactional
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserDto user){
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso!");
    }

    @PutMapping("/update-password")
    @Transactional
    public ResponseEntity<?> updatePassword(@Valid @RequestBody UpdatePasswordDto dto) {
        userService.updatePassword(dto);
        return ResponseEntity.ok("Senha alterada com sucesso.");
    }

}
