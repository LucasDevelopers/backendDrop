package com.fxdrop.fxdropapi.controller;

import com.fxdrop.fxdropapi.dto.userDto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity authUser(@Valid @RequestBody LoginDto loginRequest){
        var token = new UsernamePasswordAuthenticationToken(loginRequest.credential(), loginRequest.password());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
