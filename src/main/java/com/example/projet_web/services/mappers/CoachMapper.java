package com.example.projet_web.services.mappers;

import com.example.projet_web.Model.DTO.CoachDTO;
import com.example.projet_web.Model.entities.Coach;
import org.springframework.stereotype.Service;

@Service
public class CoachMapper implements IEntityMapper<Coach, CoachDTO> {
    @Override
    public CoachDTO entityToDTO(Coach coach) {
        return new CoachDTO(
                coach.getCoachId(),
                coach.getFirstName(),
                coach.getLastName(),
                coach.getEmail(),
                coach.getGender(),
                coach.getPassword(),
                coach.getDescription()
        );
    }
}
