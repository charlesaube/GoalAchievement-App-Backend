package com.example.projet_web.Model.entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "objectif")
@NoArgsConstructor //Lombok
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Objectif.findAll", query = "SELECT o FROM Objectif o")
        , @NamedQuery(name = "Objectif.findObjectifByID", query = "SELECT o FROM Objectif o WHERE o.objectifId = :objectifId")
        , @NamedQuery(name = "Objectif.findObjectifSortByMostRecent", query = "SELECT o FROM Objectif o order by o.startDate desc")
        , @NamedQuery(name = "Objectif.countAll", query = "SELECT count(o) FROM Objectif o")
        , @NamedQuery(name = "Objectif.findObjectifAccomplished", query = "SELECT o FROM Objectif o WHERE o.isAchieved = 1 ")
        , @NamedQuery(name = "Objectif.findObjectifByUserId", query = "SELECT o FROM Objectif o WHERE o.user.userId = :userId ")
        , @NamedQuery(name = "Objectif.findObjectifByUserIdAndCategoryId", query = "SELECT o FROM Objectif o WHERE o.user.userId = :userId AND o.category.categoryId =:categoryId")
})
public class Objectif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "objectif_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long objectifId;

    @Column(name = "objectif_name")
    private String objectifName;

    @Column(name = "start_date")
    private java.sql.Date startDate;

    @Column(name = "end_date")
    private java.sql.Date endDate;

    @Column(name = "is_achieved")
    private java.lang.Byte isAchieved;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
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

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
