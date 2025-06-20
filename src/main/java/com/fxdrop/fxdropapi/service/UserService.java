package com.fxdrop.fxdropapi.service;

import com.fxdrop.fxdropapi.dto.CreateUserDto;
import com.fxdrop.fxdropapi.dto.UserDto;
import com.fxdrop.fxdropapi.exception.CreateUserException;
import com.fxdrop.fxdropapi.exception.LoginException;
import com.fxdrop.fxdropapi.repository.UserRepository;
import com.fxdrop.fxdropapi.utils.CpfUtils;
import com.fxdrop.fxdropapi.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fxdrop.fxdropapi.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Função para Criar usuario
    public void createUser(CreateUserDto user) {
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

            String hashedPassword = PasswordUtils.passwordEncode(newUser.getPassword());
            newUser.setPassword(hashedPassword);
            newUser.setDateRegistration(LocalDateTime.now());
            newUser.setLogActive("true");
            userRepository.save(newUser);

            return;
        }
        throw new CreateUserException("CPF Inválido");
    }

    // Função de login
    public User login(String credential, String rawPassword) {
        User user = userRepository.findFirstByLoginOrEmail(credential, credential);
        if (user == null) {
            throw new LoginException("Usuário não encontrado.");
        }

        boolean senhaValida = PasswordUtils.verifyPassword(rawPassword, user.getPassword());
        if (!senhaValida) {
            throw new LoginException("Usuário ou senha inválido.");
        }

        return user;
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
}