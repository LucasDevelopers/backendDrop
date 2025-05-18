package com.fxdrop.fxdropapi.dto.user;

import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.enums.user.UserType;

import java.time.LocalDateTime;

public class UserDtoRequest {
    private Long id;
    private String password;
    private Gender gender;
    private UserType userType;
    private String login;
    private String logActive;
    private String confirmEmail;
    private LocalDateTime dateRegistration;
    private LocalDateTime dateChange;
    private LocalDateTime dateDeletion;
    private String firstName;
    private String lastName;
    private String email;
    private String cellPhone;
    private String telephone;
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogActive() {
        return logActive;
    }

    public void setLogActive(String logActive) {
        this.logActive = logActive;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public LocalDateTime getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDateTime dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public LocalDateTime getDateChange() {
        return dateChange;
    }

    public void setDateChange(LocalDateTime dateChange) {
        this.dateChange = dateChange;
    }

    public LocalDateTime getDateDeletion() {
        return dateDeletion;
    }

    public void setDateDeletion(LocalDateTime dateDeletion) {
        this.dateDeletion = dateDeletion;
    }

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
}
