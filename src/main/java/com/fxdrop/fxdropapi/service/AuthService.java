package com.fxdrop.fxdropapi.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fxdrop.fxdropapi.model.User;
import com.fxdrop.fxdropapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class AuthService implements UserDetailsService {

    @Value("{api.security.token.secret}")
    private String jwtSecret;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;

        if(username.contains("@")){
            user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        }else{
            user = userRepository.findByLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        }

        return user;
    }

    public String getToken(User user, String fingerprint){
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            return  JWT.create()
                    .withIssuer("API FXDROP")
                    .withSubject(user.getLogin())
                    .withClaim("id", user.getId())
                    .withClaim("fp", fingerprint)
                    .withExpiresAt(dateExpirate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token", exception);
        }
    }

    private Instant dateExpirate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
