package com.example.projet_web.Model.DTO;

import java.sql.Date;


public class ObjectifDTO {

    private Long objectifId;
    private String objectifName;
    private java.sql.Date startDate;
    private java.sql.Date endDate;
    private java.lang.Byte isAchieved;
    private Long categoryId;
    private Long userId;

    public ObjectifDTO(){}

    public ObjectifDTO(Long objectifId, String objectifName, Date startDate, Date endDate, Byte isAchieved, Long categoryId, Long userId) {
        this.objectifId = objectifId;
        this.objectifName = objectifName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isAchieved = isAchieved;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Long getObjectifId() {
        return this.objectifId;
    }

    public void setObjectifId(Long objectifId) {
        this.objectifId = objectifId;
    }

    public String getObjectifName() {
        return this.objectifName;
    }

    public void setObjectifName(String objectifName) {
        this.objectifName = objectifName;
    }

    public java.sql.Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public java.lang.Byte getIsAchieved() {
        return this.isAchieved;
    }

    public void setIsAchieved(java.lang.Byte isAchieved) {
        this.isAchieved = isAchieved;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
