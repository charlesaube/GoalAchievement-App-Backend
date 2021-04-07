package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.Model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {
    List<User> findUserBySubstr(String subStr);
    List<User> findUserByCoachId(Long coachId);
}
