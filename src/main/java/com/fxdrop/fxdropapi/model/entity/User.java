package com.fxdrop.fxdropapi.model.entity;

import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.enums.user.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo senha é obrigatório")
    @Column(length = 20)
    private String password;

    @NotBlank(message = "A confirmação da senha é obrigatório")
    @Column(length = 20)
    private String confirmPassword;

    @NotBlank(message="O campo genêro é obrigatório")
    @Column(nullable = false)
    private Gender gender;

    @NotBlank(message = "O campo Tipo de usuario é obrigatório")
    @Column(nullable = false)
    private UserType userType;


}
