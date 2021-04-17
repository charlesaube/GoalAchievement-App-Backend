package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.AchievementDTO;
import com.example.projet_web.Model.DTO.CoachDTO;
import com.example.projet_web.Model.DTO.ObjectifDTO;
import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.repositories.interfaces.IAchievementRepository;
import com.example.projet_web.services.implementation.AchievementService;
import com.example.projet_web.services.mappers.AchievementMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.ObjectifMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/add")
    public ResponseEntity<AchievementDTO> save(@RequestBody @Valid AchievementDTO achievement) {
        Achievement saved = this.achievementService.save(achievement);
        IEntityMapper<Achievement, AchievementDTO> mapper = new AchievementMapper();
        return new ResponseEntity<AchievementDTO>(mapper.entityToDTO(saved), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.achievementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> update(@RequestBody @Valid AchievementDTO achievement) {
        this.achievementService.update(achievement);
        return ResponseEntity.noContent().build();
    }

}
