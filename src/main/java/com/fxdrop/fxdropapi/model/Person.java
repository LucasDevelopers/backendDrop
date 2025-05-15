package com.fxdrop.fxdropapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@MappedSuperclass
public class Person {

    @NotBlank(message = "Nome é obrigatório")
    @Column(nullable = false, length = 30)
    private String firstName;
    private String lastName;

    @NotBlank(message = "O campo email é obrigatório")
    @Column(unique = true, length = 100)
    private String email;

    @NotBlank(message = "O campo celular é obrigatório")
    @Column(length = 100)
    private String cellPhone;
    private String telephone;

    @NotBlank(message = "O campo cpf é obrigatório")
    @Column(unique = true, length = 11)
    private String cpf;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", cpf='" + cpf + '\'';
    }
}