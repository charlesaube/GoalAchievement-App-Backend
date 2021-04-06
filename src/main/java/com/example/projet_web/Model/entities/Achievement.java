package com.example.projet_web.Model.entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "achievement")
@NamedQueries({
        @NamedQuery(name = "Achievement.findByAchievementById", query = "SELECT a FROM Achievement a WHERE a.achievementId = :achievementId")
        , @NamedQuery(name = "Achievement.findAllAchievementOfUser", query = "SELECT a FROM Achievement a WHERE a.user.userId = :userId")
        , @NamedQuery(name = "Achievement.findAllAchievementOfUserByCategory", query = "SELECT a FROM Achievement a WHERE a.user.userId  = :userId and a.category.categoryId = :categoryId order by a.date asc")
        })
@NoArgsConstructor //Lombok
@AllArgsConstructor
public class Achievement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private Long achievementId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private java.sql.Date date;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;

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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
