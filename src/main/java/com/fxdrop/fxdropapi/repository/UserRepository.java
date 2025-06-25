package com.fxdrop.fxdropapi.repository;

import com.fxdrop.fxdropapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByLoginOrEmail(String login, String email);
    User findFirstByEmailOrCpfOrLogin(String email, String cpf, String login);

}
