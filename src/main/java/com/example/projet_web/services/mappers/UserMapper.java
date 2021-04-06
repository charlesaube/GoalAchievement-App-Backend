package com.example.projet_web.services.mappers;

import com.example.projet_web.Model.DTO.UserDTO;
import com.example.projet_web.Model.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements IEntityMapper<User, UserDTO> {


    @Override
    public UserDTO entityToDTO(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getGender(),
                user.getPassword(),
                user.getCoach().getCoachId()
        );
    }
}
