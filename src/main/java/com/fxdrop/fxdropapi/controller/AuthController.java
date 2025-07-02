package com.fxdrop.fxdropapi.controller;

import com.fxdrop.fxdropapi.dto.auth.TokenAuth;
import com.fxdrop.fxdropapi.dto.userDto.LoginDto;
import com.fxdrop.fxdropapi.model.User;
import com.fxdrop.fxdropapi.service.AuthService;
import com.fxdrop.fxdropapi.utils.Functions;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<TokenAuth> login(@RequestBody LoginDto loginRequest,
                                           HttpServletRequest request,
                                           HttpServletResponse response) {
        var token = new UsernamePasswordAuthenticationToken(loginRequest.credential(), loginRequest.password());
        var authentication = manager.authenticate(token);

        User user = (User) authentication.getPrincipal();

        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null) {
            ipAddress = request.getHeader("X_FORWARDED_FOR");
            if (ipAddress == null){
                ipAddress = request.getRemoteAddr();
            }
        }

        String rawFingerprint = ipAddress + request.getHeader("User-Agent");
        System.out.println("ip " + ipAddress);
        System.out.println(request.getHeader("User-Agent"));
        String fingerprint = Functions.sha256(rawFingerprint);

        String jwtToken = authService.getToken(user, fingerprint);

        Cookie cookie = new Cookie("fp", fingerprint);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(2 * 60 * 60); // 2 horas
        response.addCookie(cookie);

        return ResponseEntity.ok(new TokenAuth(jwtToken));
    }
}
