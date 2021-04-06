package com.example.projet_web.services.mappers;

import com.example.projet_web.Model.DTO.AchievementDTO;
import com.example.projet_web.Model.entities.Achievement;
import org.springframework.stereotype.Service;

@Service
public class AchievementMapper implements IEntityMapper<Achievement,AchievementDTO> {
    @Override
    public AchievementDTO entityToDTO(Achievement achievement) {
        return new AchievementDTO(achievement.getAchievementId(),
                achievement.getTitle(), achievement.getDescription(),
                achievement.getDate(),
                achievement.getUser().getUserId(),
                achievement.getCategory().getCategoryId());
    }
}
