package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAchievementRepository extends JpaRepository<Achievement,Long> {

     List<Achievement> findAllAchievementOfUser(Long userId);
     List<Achievement> findAllAchievementOfUserByCategory(Long userId, Long categoryId);
}
