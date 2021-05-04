package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICoachRepository extends JpaRepository<Coach,Long> {
    List<Coach> findAllCoachByFirstNameSubString(String subStr);
    List<Coach> findCoachsOrderByLeastUsed();
}
