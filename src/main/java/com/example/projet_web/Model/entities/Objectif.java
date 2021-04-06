package com.example.projet_web.Model.entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "objectif")
@NoArgsConstructor //Lombok
@AllArgsConstructor
public class Objectif {
    @Id
    @Column(name = "objectifId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objectifId;

    @Column(name = "objectifName")
    private String objectifName;

    @Column(name = "startDate")
    private java.sql.Date startDate;

    @Column(name = "endDate")
    private java.sql.Date endDate;

    @Column(name = "isAchieved")
    private java.lang.Byte isAchieved;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

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

    public Long getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
