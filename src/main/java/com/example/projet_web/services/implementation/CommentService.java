package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.Comment;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.repositories.interfaces.ICommentRepository;
import com.example.projet_web.repositories.interfaces.IObjectifRepository;
import com.example.projet_web.services.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;

    @Autowired
    public CommentService(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comment> readOne(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findAllByObjectifId(Long objectifId) {
        return commentRepository.findAllByObjectifId(objectifId);
    }


    @Override
    public List<Comment> findAllByUserId(Long userId) {
        return commentRepository.findAllByUserId(userId);
    }

    @Override
    public List<Comment> findAllByCoachId(Long coachId) {
        return commentRepository.findAllByCoachId(coachId);
    }
}
