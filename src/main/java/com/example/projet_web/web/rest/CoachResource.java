package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.CoachDTO;
import com.example.projet_web.Model.DTO.CommentDTO;
import com.example.projet_web.Model.DTO.ObjectifDTO;
import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.Coach;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.services.implementation.CoachService;
import com.example.projet_web.services.mappers.CoachMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.ObjectifMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/coach")
public class CoachResource {
    private final CoachService coachService;
    private final CoachMapper mapper;

    public CoachResource(CoachService coachService, CoachMapper mapper) {
        this.coachService = coachService;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<CoachDTO> getAll()
    {
        IEntityMapper<Coach, CoachDTO> mapper = new CoachMapper();
        return coachService.readAll().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public CoachDTO getUserById(@PathVariable long id){
        return coachService.readOne(id).map(mapper::entityToDTO).get();
    }

    @GetMapping("/leastUsed/{limit}")
    public ResponseEntity<List<CoachDTO>> getCoachsLeastUsed(@PathVariable int limit){
        List<CoachDTO> coachsDTO = coachService.getCoachsWithleastUser(limit).stream().map(mapper::entityToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(coachsDTO,HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<CoachDTO> save(@RequestBody @Valid CoachDTO coach) {
        Coach saved = this.coachService.save(coach);
        return new ResponseEntity<>(mapper.entityToDTO(saved), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.coachService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<CoachDTO> update(@RequestBody @Valid CoachDTO coach) {
        Coach updated = this.coachService.update(coach);
        return new ResponseEntity<>(mapper.entityToDTO(updated), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody @Valid CoachDTO coachDTO ) {
        Coach coach = this.coachService.authenticate(coachDTO);
        if (coach != null)
        {
            return new ResponseEntity<>(mapper.entityToDTO(coach),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }


}
