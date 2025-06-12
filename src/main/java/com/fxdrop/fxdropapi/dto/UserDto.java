package com.fxdrop.fxdropapi.dto;

import com.fxdrop.fxdropapi.enums.user.Gender;

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
) {}
