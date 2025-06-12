package com.fxdrop.fxdropapi.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {
    @NotBlank(message = "O campo credential (login ou email) é obrigatório")
    private String credential;

    @NotBlank(message = "O campo password é obrigatório")
    private String password;

    // Getters e Setters
    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
