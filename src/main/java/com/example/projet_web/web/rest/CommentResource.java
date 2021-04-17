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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/add")
    public ResponseEntity<CommentDTO> save (@RequestBody @Valid CommentDTO comment){
        Comment saved = this.commentService.save(comment);
        IEntityMapper<Comment, CommentDTO> mapper = new CommentMapper();
        return new ResponseEntity<CommentDTO>(mapper.entityToDTO(saved), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.commentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> update(@RequestBody @Valid CommentDTO comment) {
        this.commentService.update(comment);
        return ResponseEntity.noContent().build();
    }

}
