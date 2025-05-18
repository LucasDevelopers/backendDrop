package com.fxdrop.fxdropapi.model;

import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.enums.user.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo senha é obrigatório")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message="O campo gênero é obrigatório")
    @Column(nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo Tipo de usuário é obrigatório")
    @Column(nullable = false)
    private UserType userType;

    @NotBlank(message = "O campo login é obrigatório")
    @Column(unique = true, nullable = false)
    private String login;

    @NotBlank(message = "O status do Usuário é obrigatório")
    @Column(nullable = false)
    private String logActive;

    @Column(nullable = true)
    private String confirmEmail;

    @NotNull(message = "A data de criação é obrigatória")
    @Column(nullable = false)
    private LocalDateTime dateRegistration;

    @Column(nullable = true)
    private Long idRegistration;

    @Column(nullable = true)
    private LocalDateTime dateChange;

    @Column(nullable = true)
    private Long idChange;

    @Column(nullable = true)
    private LocalDateTime dateDeletion;

    @Column(nullable = true)
    private Long idDeletion;

    public Long getId() {
        return id;
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

    public Long getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Long idRegistration) {
        this.idRegistration = idRegistration;
    }

    public LocalDateTime getDateChange() {
        return dateChange;
    }

    public void setDateChange(LocalDateTime dateChange) {
        this.dateChange = dateChange;
    }

    public Long getIdChange() {
        return idChange;
    }

    public void setIdChange(Long idChange) {
        this.idChange = idChange;
    }

    public LocalDateTime getDateDeletion() {
        return dateDeletion;
    }

    public void setDateDeletion(LocalDateTime dateDeletion) {
        this.dateDeletion = dateDeletion;
    }

    public Long getIdDeletion() {
        return idDeletion;
    }

    public void setIdDeletion(Long idDeletion) {
        this.idDeletion = idDeletion;
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                "id=" + id +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", userType=" + userType +
                ", login='" + login + '\'' +
                ", logActive='" + logActive + '\'' +
                ", confirmEmail='" + confirmEmail + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", idRegistration=" + idRegistration +
                ", dateChange=" + dateChange +
                ", idChange=" + idChange +
                ", dateDeletion=" + dateDeletion +
                ", idDeletion=" + idDeletion +
                '}';
    }
}
