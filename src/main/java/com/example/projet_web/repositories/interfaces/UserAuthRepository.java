package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
    Optional<UserAuth> findOneByUsername(String username);
}
