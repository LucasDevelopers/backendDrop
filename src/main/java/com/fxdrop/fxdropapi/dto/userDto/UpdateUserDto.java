package com.fxdrop.fxdropapi.dto.userDto;

import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.enums.user.UserType;
import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(
        @NotNull(message = "O id do usúario é obrigatório")
        Long id,

        Gender gender,

        UserType userType,

        String firstName,

        String lastName,

        String cellPhone,

        String telephone,

        String confirmEmail,

        Long idUpdate,

        Long idDeletion,

        Long companyId
) {
}
