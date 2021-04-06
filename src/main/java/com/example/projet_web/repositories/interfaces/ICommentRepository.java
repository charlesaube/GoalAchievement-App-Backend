package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Long> {
}
