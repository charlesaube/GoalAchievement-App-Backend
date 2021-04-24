package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.AchievementDTO;
import com.example.projet_web.Model.DTO.CategoryDTO;
import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.services.implementation.UserService;
import com.example.projet_web.services.mappers.AchievementMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserResource {
    private final UserService userService;
    private final UserMapper mapper;

    public UserResource(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @CrossOrigin
    @GetMapping("/all")
    public List<UserDTO> getAll()
    {
        IEntityMapper<User, UserDTO> mapper = new UserMapper();
        return this.userService.readAll().stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    public UserDTO getUserById(@PathVariable long id){
        return userService.readOne(id).map(mapper::entityToDTO).get();
    }

    @GetMapping ("/coach/{coachId}")
    public List<UserDTO> getUserByCoachId(@PathVariable long coachId) {
        IEntityMapper<User, UserDTO> mapper = new UserMapper();
        List<UserDTO> userDTO = userService.findUserByCoachId(coachId).stream().map(mapper::entityToDTO).collect(Collectors.toList());
        return userDTO;
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO user) {
        User saved = this.userService.save(user);
        IEntityMapper<User, UserDTO> mapper = new UserMapper();
        return new ResponseEntity<UserDTO>(mapper.entityToDTO(saved), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> update(@RequestBody @Valid UserDTO user) {
        this.userService.update(user);
        return ResponseEntity.noContent().build();
    }







}




























