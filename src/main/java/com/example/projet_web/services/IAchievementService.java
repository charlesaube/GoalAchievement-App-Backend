package com.example.projet_web.services;

import com.example.projet_web.Model.entities.Achievement;
import java.util.List;
import java.util.Optional;

public interface IAchievementService {

    Achievement create(Achievement achievement);

    Optional<Achievement> readOne(Long achievementId);

    List<Achievement> readAll();

    void delete(Long achievementId);

    List<Achievement> getAllAchievementOfUser(Long userId);

    List<Achievement> getAllAchievementOfUserByCategory(Long userId, Long categoryId);

}
