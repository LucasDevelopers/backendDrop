package com.fxdrop.fxdropapi.dto.userDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePasswordDto(
        @NotNull(message = "ID do usuário é obrigatório")
        Long id,

        @NotBlank(message = "Senha atual é obrigatória")
        String currentPassword,

        @NotBlank(message = "Nova senha é obrigatória")
        String newPassword,

        @NotBlank(message = "Confirmação de nova senha é obrigatória")
        String validateNewPassword
) {
}
