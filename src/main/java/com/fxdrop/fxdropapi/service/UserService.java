package com.fxdrop.fxdropapi.service;

import com.fxdrop.fxdropapi.dto.userDto.CreateUserDto;
import com.fxdrop.fxdropapi.dto.userDto.UpdatePasswordDto;
import com.fxdrop.fxdropapi.dto.userDto.UpdateUserDto;
import com.fxdrop.fxdropapi.dto.userDto.UserDto;
import com.fxdrop.fxdropapi.exception.CreateUserException;
import com.fxdrop.fxdropapi.exception.LoginException;
import com.fxdrop.fxdropapi.repository.UserRepository;
import com.fxdrop.fxdropapi.utils.CpfUtils;
import com.fxdrop.fxdropapi.utils.Functions;
import com.fxdrop.fxdropapi.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.fxdrop.fxdropapi.model.User;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //Função para Criar usuario
    public void createUser(CreateUserDto user) {
        if (!user.password().equals(user.validatePassword())) {
            throw new CreateUserException("As senhas não coincidem.");
        }

        User newUser = fromDto(user);

        String cleanCpf = CpfUtils.cleanCpf(newUser.getCpf());
        newUser.setCpf(cleanCpf);

        boolean validateCpf = CpfUtils.cpfValidate(newUser.getCpf());

        if(validateCpf){
            User searchUser = userRepository.findFirstByEmailOrCpfOrLogin(newUser.getEmail(), newUser.getCpf(), newUser.getLogin());

            if(searchUser != null){
                if (searchUser.getEmail().equals(newUser.getEmail())){
                    throw new CreateUserException("E-mail já cadastrado.");
                }

                if(searchUser.getCpf().equals(newUser.getCpf())){
                    throw new CreateUserException("Cpf já cadastro.");
                }

                if(searchUser.getLogin().equals(newUser.getLogin())){
                    throw new CreateUserException("Login já cadastrado.");
                }
            }

            String hashedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(hashedPassword);
            String cellPhone = Functions.cleanString(newUser.getCellPhone());
            newUser.setCellPhone(cellPhone);
            newUser.setDateCreate(LocalDateTime.now());
            newUser.setLogActive("true");
            userRepository.save(newUser);

            return;
        }
        throw new CreateUserException("CPF Inválido");
    }

    public void updateUser(UpdateUserDto userDto){
        User user = userRepository.getReferenceById(userDto.id());

        if (userDto.gender() != null) {
            user.setGender(userDto.gender());
        }
        if (userDto.userType() != null) {
            user.setUserType(userDto.userType());
        }
        if (userDto.firstName() != null) {
            user.setFirstName(userDto.firstName());
        }
        if (userDto.lastName() != null) {
            user.setLastName(userDto.lastName());
        }
        if (userDto.cellPhone() != null) {
            String cellPhone = Functions.cleanString(userDto.cellPhone());
            user.setCellPhone(cellPhone);
        }
        if (userDto.telephone() != null) {
            user.setTelephone(userDto.telephone());
        }

    }

    //Listar todos os usuarios
    public Page<UserDto> listAllUser(Pageable pagination) {
        return (userRepository.findAll(pagination).map(UserDto::new));
    }
    //Converter Usuario para Dto
    private User fromDto(CreateUserDto dto){
        User user = new User();
        user.setLogin(dto.login());
        user.setPassword(dto.password());
        user.setGender(dto.gender());
        user.setUserType(dto.userType());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setCellPhone(dto.cellPhone());
        user.setTelephone(dto.telephone());
        user.setCpf(dto.cpf());

        return user;
    }

    public void updatePassword(UpdatePasswordDto dto) {
        User user = userRepository.getReferenceById(dto.id());

        if (!PasswordUtils.verifyPassword(dto.currentPassword(), user.getPassword())) {
            throw new CreateUserException("Senha atual inválida.");
        }

        if (PasswordUtils.verifyPassword(dto.newPassword(), user.getPassword())) {
            throw new CreateUserException("A nova senha não pode ser igual a atual.");
        }

        if (!dto.newPassword().equals(dto.validateNewPassword())) {
            throw new CreateUserException("Nova senha e confirmação não coincidem.");
        }

        String hashedNewPassword = PasswordUtils.passwordEncode(dto.newPassword());
        user.setPassword(hashedNewPassword);
    }

}