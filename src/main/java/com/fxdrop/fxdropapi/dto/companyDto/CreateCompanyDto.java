package com.fxdrop.fxdropapi.dto.companyDto;

import com.fxdrop.fxdropapi.enums.company.TypeCompany;
import com.fxdrop.fxdropapi.model.Company;
import jakarta.validation.constraints.NotNull;

public record CreateCompanyDto(
        @NotNull(message = "Razão Social é obrigatório")
        String corporateReason,

        @NotNull(message = "Nome Fantasia é obrigatório")
        String fantasyName,

        @NotNull(message = "CNPJ é obrigatório")
        String cnpj,

        String ie,

        @NotNull(message = "Celular é obrigatório")
        String cellphone,

        String telephone,

        @NotNull(message = "Logradouro é obrigatório")
        String adress,

        @NotNull(message = "Numero é obrigatório")
        String number,

        String complement,

        @NotNull(message = "Bairro é obrigatório")
        String neighborhood,

        @NotNull(message = "Cep é obrigatório")
        String zipCode,

        @NotNull(message = "Cidade é obrigatório")
        String city,

        @NotNull(message = "Estado é obrigatório")
        String state,

        String domain,

        @NotNull(message = "Tipo de empresa é obrigatório")
        TypeCompany typeCompany,

        @NotNull(message = "Id do usuário que criou é obrigatório")
        Long id
) {}
