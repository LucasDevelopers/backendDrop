package com.fxdrop.fxdropapi.controller;

import com.fxdrop.fxdropapi.dto.userDto.*;
import com.fxdrop.fxdropapi.exception.CreateUserException;
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
    public ResponseEntity<Page<UserDto>> getAllUser(Pageable pagination){
        var page = userService.listAllUser(pagination);
        return ResponseEntity.ok(page);
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
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário Atualizado com sucesso!");
    }

    @PutMapping("/update-password")
    @Transactional
    public ResponseEntity<?> updatePassword(@Valid @RequestBody UpdatePasswordDto dto) {
        userService.updatePassword(dto);
        return ResponseEntity.ok("Senha alterada com sucesso.");
    }

    @DeleteMapping("/delete-user/{id}")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}
