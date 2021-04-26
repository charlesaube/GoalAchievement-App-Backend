package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.services.implementation.UserService;
import com.example.projet_web.services.mappers.IEntityMapper;
import com.example.projet_web.services.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        List<UserDTO> userDTO = userService.findUserByCoachId(coachId).stream().map(mapper::entityToDTO).collect(Collectors.toList());
        return userDTO;
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO user) {
        User saved = this.userService.save(user);
        return new ResponseEntity<>(mapper.entityToDTO(saved), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/authenticate")
    public UserDTO authenticate(@RequestBody @Valid UserDTO userDTO ) {

        for( User user: this.userService.readAll()){
            if ( user.getEmail().equals( userDTO.getEmail()) && user.getPassword().equals( userDTO.getPassword()) )
            {
                IEntityMapper<User, UserDTO> mapper = new UserMapper();
                return mapper.entityToDTO(user);
            }
        }

        return userDTO;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/edit")
    public ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO user) {
        User updated = this.userService.update(user);
        return new ResponseEntity<>(mapper.entityToDTO(updated), HttpStatus.OK);
    }







}




























