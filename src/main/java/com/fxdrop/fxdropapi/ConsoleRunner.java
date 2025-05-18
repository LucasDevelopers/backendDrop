package com.fxdrop.fxdropapi;

import com.fxdrop.fxdropapi.enums.user.Gender;
import com.fxdrop.fxdropapi.enums.user.UserType;
import com.fxdrop.fxdropapi.model.User;
import com.fxdrop.fxdropapi.service.UserService;
import com.fxdrop.fxdropapi.utils.PasswordUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import static java.time.LocalDateTime.now;


@Component
public class ConsoleRunner implements CommandLineRunner {
    private final UserService userService;

    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run (String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        System.out.println("Digite o nome do Usuário para criar: ");
        String firstName = scanner.nextLine();
        user.setFirstName(firstName);

        System.out.println("Digite o sobrenome do Usuário para criar: ");
        String lastName = scanner.nextLine();
        user.setLastName(lastName);

        System.out.println("Digite o email: ");
        String email = scanner.nextLine();
        user.setEmail(email);

        System.out.println("Digite o telefone: ");
        String telephone = scanner.nextLine();
        user.setTelephone(telephone);

        System.out.println("Digite o celular: ");
        String cellPhone = scanner.nextLine();
        user.setCellPhone(cellPhone);

        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine();
        user.setCpf(cpf);

        System.out.println("Escolha seu Genêro: ");
        System.out.println("M para Masculino");
        System.out.println("F para Feminino");
        System.out.println("O para outros");
        String genderInput = scanner.nextLine().toUpperCase();
        Gender genderEnum = Gender.valueOf(genderInput);
        user.setGender(genderEnum);

        System.out.println("Digite o login: ");
        String login = scanner.nextLine();
        user.setLogin(login);

        System.out.println("Digite a senha: ");
        String password = scanner.nextLine();
        String passwordEncode = PasswordUtils.passwordEncode(password);
        user.setPassword(passwordEncode);

        boolean teste = PasswordUtils.verifyPassword(password, passwordEncode);

        System.out.println(teste);

        user.setLogActive("S");
//        user.setIdRegistration(Long.valueOf("123456dfad12zxd"));
        user.setUserType(UserType.valueOf("fxAdmin"));
        user.setDateRegistration(now());
        user.setConfirmEmail("false");
        userService.createUser(user);

        List<User> todosUsuarios = userService.listUser();
        System.out.println("lista de usuarios");
        System.out.println(todosUsuarios);

    }
}
