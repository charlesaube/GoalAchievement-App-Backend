package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.DTO.CommentDTO;
import com.example.projet_web.Model.entities.Coach;
import com.example.projet_web.Model.entities.Comment;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.repositories.interfaces.ICommentRepository;
import com.example.projet_web.services.ICoachService;
import com.example.projet_web.services.ICommentService;
import com.example.projet_web.services.IObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;
    private final IObjectifService objectifService;
    private final ICoachService coachService;

    @Autowired
    public CommentService(ICommentRepository commentRepository, IObjectifService objectifService, ICoachService coachService) {
        this.commentRepository = commentRepository;
        this.objectifService = objectifService;
        this.coachService = coachService;
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

    @Override
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public Comment save(CommentDTO commentDTO) {
        Coach coach = coachService.readOne(commentDTO.getCoachId()).get();
        Objectif objectif = objectifService.readOne(commentDTO.getObjectifId()).get();
        Comment comment = new Comment();
        comment.setCoach(coach);
        comment.setDescription(commentDTO.getDescription());
        comment.setObjectif(objectif);
        comment.setTitle(commentDTO.getTitle());
        return commentRepository.save(comment);
    }
}
