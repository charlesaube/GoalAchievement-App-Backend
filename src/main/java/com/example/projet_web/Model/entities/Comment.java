package com.example.projet_web.Model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
@NoArgsConstructor //Lombok
@AllArgsConstructor
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "commentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "objectifId", referencedColumnName = "objectifId")
    private Objectif objectif;

    @ManyToOne
    @JoinColumn(name = "coachId", referencedColumnName = "coachId")
    private Coach coach;

    public Long getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public Long getObjectif() {
        return this.objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    public Long getCoach() { return this.coach; }

    public void setCoach( Coach coach) {
        this.coach = coach;
    }
}
