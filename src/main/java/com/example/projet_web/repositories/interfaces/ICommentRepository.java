package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByObjectifId(Long objectifId);
    List<Comment> findAllByUserId(Long userId);
    List<Comment> findAllByCoachId(Long coachId);
}
