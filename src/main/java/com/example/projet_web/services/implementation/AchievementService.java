package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.DTO.AchievementDTO;
import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.Model.entities.Coach;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.repositories.interfaces.IAchievementRepository;
import com.example.projet_web.services.IAchievementService;
import com.example.projet_web.services.ICategoryService;
import com.example.projet_web.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AchievementService implements IAchievementService {

    private final IAchievementRepository achievementRepository;
    private final IUserService userService;
    private final ICategoryService categoryService;

    @Autowired
    public AchievementService(IAchievementRepository achievementRepository, IUserService userService, ICategoryService categoryService){ this.achievementRepository = achievementRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

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

    @Override
    public Achievement save(AchievementDTO achievementDTO) {
        Category category = categoryService.readOne(achievementDTO.getCategoryId()).get();
        User user = userService.readOne(achievementDTO.getUserId()).get();

        Achievement achievement = new Achievement();
        achievement.setCategory(category);
        achievement.setDescription(achievementDTO.getDescription());
        achievement.setDate(achievementDTO.getDate());
        achievement.setTitle(achievementDTO.getTitle());
        achievement.setUser(user);

        return achievementRepository.save(achievement);
    }

    @Override
    public void update(AchievementDTO achievementDTO) {
        Optional<Achievement> storedOptional = readOne(achievementDTO.getAchievementId());

        if (storedOptional.isPresent()) {
            Achievement stored = storedOptional.get();

            Category category = categoryService.readOne(achievementDTO.getCategoryId()).get();
            User user = userService.readOne(achievementDTO.getUserId()).get();

            stored.setCategory(category);
            stored.setDescription(achievementDTO.getDescription());
            stored.setDate(achievementDTO.getDate());
            stored.setTitle(achievementDTO.getTitle());
            stored.setUser(user);
            achievementRepository.save(stored);
        }
    }
}
