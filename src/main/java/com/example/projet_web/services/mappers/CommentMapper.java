package com.example.projet_web.services.mappers;

import com.example.projet_web.Model.DTO.CommentDTO;
import com.example.projet_web.Model.entities.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper implements IEntityMapper<Comment, CommentDTO>{
    @Override
    public CommentDTO entityToDTO(Comment comment) {
        return new CommentDTO(
                comment.getCommentId(),
                comment.getTitle(),
                comment.getDescription(),
                comment.getCoach().getCoachId(),
                comment.getObjectif().getObjectifId()
        );
    }
}
