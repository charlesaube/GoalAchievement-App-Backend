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

    @CrossOrigin
    @GetMapping("/all")
    public List<AchievementDTO> getAll()
    {
        IEntityMapper<Achievement , AchievementDTO> mapper = new AchievementMapper();
        return this.achievementService.readAll().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<AchievementDTO> save(@RequestBody @Valid AchievementDTO achievement) {
        Achievement saved = this.achievementService.save(achievement);
        return new ResponseEntity<>(achievementMapper.entityToDTO(saved), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.achievementService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @PutMapping("/edit")
    public ResponseEntity<AchievementDTO> update(@RequestBody @Valid AchievementDTO achievement) {
        Achievement updated = this.achievementService.update(achievement);
        return new ResponseEntity<>(achievementMapper.entityToDTO(updated), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/userId/{id}")
    public  List<AchievementDTO> getAchievementByUserId(@PathVariable Long id)
    {
        IEntityMapper<Achievement, AchievementDTO> mapper = new AchievementMapper();
        return achievementService.getAllAchievementOfUser(id).stream().map(mapper::entityToDTO).collect(Collectors.toList());

    }

}
