package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.AchievementDTO;
import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.repositories.interfaces.IAchievementRepository;
import com.example.projet_web.services.implementation.AchievementService;
import com.example.projet_web.services.mappers.AchievementMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/achievement")
public class AchievementResource {
    private final AchievementService achievementService;
    private final AchievementMapper achievementMapper;

    public AchievementResource(AchievementService achievementService, AchievementMapper achievementMapper) {
        this.achievementService = achievementService;
        this.achievementMapper = achievementMapper;
    }

    @GetMapping("/all")
    public List<AchievementDTO> getAll()
    {
        IEntityMapper<Achievement , AchievementDTO> mapper = new AchievementMapper();
        return this.achievementService.readAll().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }


}
