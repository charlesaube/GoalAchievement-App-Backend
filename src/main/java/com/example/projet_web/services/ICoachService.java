package com.example.projet_web.services;

import com.example.projet_web.Model.DTO.CoachDTO;
import com.example.projet_web.Model.entities.Coach;


import java.util.List;
import java.util.Optional;

public interface ICoachService {
    Coach create(Coach coach);

    Optional<Coach> readOne(Long coachId);
    List<Coach> readAll();
    void delete(Long coachId);
    List<Coach> getAllCoachByFirstNameSubString(String subStr);
    Coach save(CoachDTO coachDTO);
    Coach update(CoachDTO coachDTO);
    Coach authenticate(CoachDTO coachDTO);
}
