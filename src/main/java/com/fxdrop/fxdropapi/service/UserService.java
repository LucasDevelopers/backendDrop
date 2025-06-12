package com.fxdrop.fxdropapi.service;

import com.fxdrop.fxdropapi.dto.UserDto;
import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.repository.UserRepository;
import com.fxdrop.fxdropapi.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fxdrop.fxdropapi.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        String hashedPassword = PasswordUtils.passwordEncode(user.getPassword());
        user.setPassword(hashedPassword);

        userRepository.save(user);
    }

    public List<UserDto> listAllUser() {
        return toDto(userRepository.findAll());
    }

    private List<UserDto> toDto(List<User> users){
        return users.stream()
                .map(u -> new UserDto(u.getId(), u.getGender(), u.getLogin(), u.getLogActive(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getCellPhone(), u.getTelephone(), u.getCpf()))
                .collect(Collectors.toList());
    }

    public User login(String credential, String rawPassword) {
        User user = userRepository.login(credential);
        if (user != null) {
            boolean senhaValida = PasswordUtils.verifyPassword(rawPassword, user.getPassword());
            if (senhaValida) {
                return user;
            }
        }
        return null; // login falhou
    }
}