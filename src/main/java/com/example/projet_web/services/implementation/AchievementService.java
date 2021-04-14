package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.repositories.interfaces.IAchievementRepository;
import com.example.projet_web.services.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AchievementService implements IAchievementService {

    private final IAchievementRepository achievementRepository;

    @Autowired
    public AchievementService(IAchievementRepository achievementRepository){ this.achievementRepository = achievementRepository;}

    @Override
    public Achievement create(Achievement achievement) {
        return achievementRepository.save(achievement);
    }

    @Override
    public Optional<Achievement> readOne(Long achievementId) {
        return achievementRepository.findById(achievementId);
    }

    @Override
    public List<Achievement> readAll() {
        return achievementRepository.findAll();
    }

    @Override
    public void delete(Long achievementId) {
        achievementRepository.deleteById(achievementId);
    }

    @Override
    public List<Achievement> getAllAchievementOfUser(Long userId) {
        return achievementRepository.findAllAchievementOfUser(userId);
    }

    @Override
    public List<Achievement> getAllAchievementOfUserByCategory(Long userId, Long categoryId) {
        return achievementRepository.findAllAchievementOfUserByCategory(userId,categoryId);
    }
}
