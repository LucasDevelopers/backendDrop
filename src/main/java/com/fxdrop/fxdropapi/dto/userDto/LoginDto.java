package com.fxdrop.fxdropapi.dto.userDto;

import jakarta.validation.constraints.NotBlank;

public record LoginDto(
        @NotBlank(message = "O campo credential (login ou email) é obrigatório")
        String credential,

        @NotBlank(message = "O campo password é obrigatório")
        String password
) {
    }
