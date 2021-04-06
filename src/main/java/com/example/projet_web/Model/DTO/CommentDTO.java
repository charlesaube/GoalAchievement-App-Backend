package com.example.projet_web.Model.DTO;

public class CommentDTO {
    private Long commentId;
    private String title;
    private String description;
    private Long objectifId;
    private Long coachId;
    public CommentDTO(){}

    public CommentDTO(Long commentId, String title, String description, Long objectifId, Long coachId) {
        this.commentId = commentId;
        this.title = title;
        this.description = description;
        this.objectifId = objectifId;
        this.coachId = coachId;
    }

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

    public Long getObjectifId() {
        return this.objectifId;
    }

    public void setObjectifId(Long objectifId) {
        this.objectifId = objectifId;
    }

    public Long getCoachId() {
        return this.coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
}
