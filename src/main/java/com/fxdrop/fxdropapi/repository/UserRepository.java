package com.fxdrop.fxdropapi.repository;

import com.fxdrop.fxdropapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :credential OR u.email = :credential")
    User login(@Param("credential") String credential);


}
