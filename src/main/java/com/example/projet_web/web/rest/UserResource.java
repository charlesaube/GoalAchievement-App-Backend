package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.CategoryDTO;
import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.services.implementation.UserService;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.UserMapper;
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
@RequestMapping("api/user")
public class UserResource {
    private final UserService userService;
    private final UserMapper mapper;

    public UserResource(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
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



}




























