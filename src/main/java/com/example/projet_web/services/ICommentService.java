package com.example.projet_web.services;

import com.example.projet_web.Model.DTO.CommentDTO;
import com.example.projet_web.Model.entities.Comment;
import com.example.projet_web.Model.entities.Objectif;

import java.util.List;
import java.util.Optional;

public interface ICommentService {
    Optional<Comment> readOne(long Id);

    List<Comment> findAllByObjectifId(Long objectifId);
    List<Comment> findAllByUserId(Long userId);
    List<Comment> findAllByCoachId(Long coachId);
    Comment save(CommentDTO commentDTO);
}
