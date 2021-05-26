package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.CategoryDTO;
import com.example.projet_web.Model.DTO.ObjectifDTO;
import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.services.implementation.ObjectifService;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.ObjectifMapper;
import com.example.projet_web.services.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/objectif")
public class ObjectifResource {
    private final ObjectifService objectifService;
    private final ObjectifMapper mapper;

    public ObjectifResource(ObjectifService objectifService, ObjectifMapper mapper) {
        this.objectifService = objectifService;
        this.mapper = mapper;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<ObjectifDTO> getAll()
    {
        IEntityMapper<Objectif, ObjectifDTO> mapper = new ObjectifMapper();
        return objectifService.readAll().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }
    @CrossOrigin
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getObjectifById(@PathVariable long id)
    {
        Optional<Objectif> objectif = objectifService.readOne(id);
        Optional<ObjectifDTO> categoryDTO = objectif.map(mapper::entityToDTO);
        return categoryDTO.isPresent() ? new ResponseEntity<>(categoryDTO.get(),
                HttpStatus.OK) : new ResponseEntity<>("Objectif Id not found", HttpStatus.NOT_FOUND);
    }
    @CrossOrigin
    @GetMapping("/most-recent")
    public List<ObjectifDTO> getObjectifByMostRecent(){
        IEntityMapper<Objectif, ObjectifDTO> mapper = new ObjectifMapper();
        return objectifService.findObjectifSortByMostRecent().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }
    @CrossOrigin
    @GetMapping("/accomplished")
    public List<ObjectifDTO> getAccomplished() {
        IEntityMapper<Objectif, ObjectifDTO> mapper = new ObjectifMapper();
        return objectifService.findObjectifAccomplished().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }
    @CrossOrigin
    @GetMapping("/count")
    public Long countAll(){
        return objectifService.countAll();
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<ObjectifDTO> save(@RequestBody @Valid ObjectifDTO objectif) {
        Objectif saved = this.objectifService.save(objectif);
        return new ResponseEntity<>(mapper.entityToDTO(saved), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.objectifService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin
    @PutMapping("/edit")
    public ResponseEntity<ObjectifDTO> update(@RequestBody @Valid ObjectifDTO objectif) {
        Objectif updated = this.objectifService.update(objectif);
        return new ResponseEntity<>(mapper.entityToDTO(updated), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/userId/{id}")
    public  List<ObjectifDTO> getObjectifByUserId(@PathVariable Long id)
    {
        IEntityMapper<Objectif, ObjectifDTO> mapper = new ObjectifMapper();
        return objectifService.findObjectifByUserId(id).stream().map(mapper::entityToDTO).collect(Collectors.toList());

    }



}
