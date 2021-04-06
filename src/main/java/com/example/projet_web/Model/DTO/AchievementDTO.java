package com.example.projet_web.Model.DTO;

import java.sql.Date;

public class AchievementDTO {

    private Long achievementId;
    private String title;
    private String description;
    private java.sql.Date date;
    private Long userId;
    private Long categoryId;

    public AchievementDTO(){}

    public AchievementDTO(Long achievementId, String title, String description, Date date, Long userId, Long categoryId) {
        this.achievementId = achievementId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getAchievementId() {
        return this.achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getDate() {
        return this.date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
