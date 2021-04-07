package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.CommentDTO;
import com.example.projet_web.Model.DTO.ObjectifDTO;
import com.example.projet_web.Model.entities.Comment;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.services.implementation.CommentService;
import com.example.projet_web.services.mappers.CommentMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.ObjectifMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/comment")
public class CommentResource {
    private final CommentService commentService;
    private final CommentMapper mapper;

    public CommentResource(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @GetMapping("/objectif-id/{id}")
    public List<CommentDTO> getByObjectifId(@PathVariable long id){

        IEntityMapper<Comment, CommentDTO> mapper = new CommentMapper();
        return commentService.findAllByObjectifId(id).stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }
    @GetMapping("/user-id/{id}")
    public List<CommentDTO> getByUserId(@PathVariable long id){

        IEntityMapper<Comment, CommentDTO> mapper = new CommentMapper();
        return commentService.findAllByUserId(id).stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }
    @GetMapping("/coach-id/{id}")
    public List<CommentDTO> getByCoachId(@PathVariable long id){

        IEntityMapper<Comment, CommentDTO> mapper = new CommentMapper();
        return commentService.findAllByCoachId(id).stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }

}
