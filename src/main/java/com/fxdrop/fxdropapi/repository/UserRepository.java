package com.fxdrop.fxdropapi.repository;

import com.fxdrop.fxdropapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByLoginOrEmail(String login, String email);
    User findFirstByEmailOrCpfOrLogin(String email, String cpf, String login);
    Optional<User> findByLogin(String login);
    Optional<User> findByEmail(String email);
}
