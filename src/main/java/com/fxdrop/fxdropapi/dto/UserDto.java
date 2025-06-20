package com.fxdrop.fxdropapi.dto;

import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.model.User;

import java.time.LocalDateTime;

public record UserDto (     Long id,
                            Gender gender,
                            String login,
                            String logActive,
                            String firstName,
                            String lastName,
                            String email,
                            String cellPhone,
                            String telephone,
                            String cpf
) {
    public UserDto(User user) {
        this(
                user.getId(),
                user.getGender(),
                user.getLogin(),
                user.getLogActive(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getCellPhone(),
                user.getTelephone(),
                user.getCpf()
        );
    }
}
