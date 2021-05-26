package com.example.projet_web.services.mappers;

import com.example.projet_web.Model.DTO.ObjectifDTO;
import com.example.projet_web.Model.entities.Objectif;
import org.springframework.stereotype.Service;

@Service
public class ObjectifMapper implements IEntityMapper<Objectif, ObjectifDTO> {

    @Override
    public ObjectifDTO entityToDTO(Objectif objectif) {
        return new ObjectifDTO(
                objectif.getObjectifId(),
                objectif.getObjectifName(),
                objectif.getStartDate(),
                objectif.getEndDate(),
                objectif.getIsAchieved(),
                objectif.getCategory().getCategoryId(),
                objectif.getUser().getUserId()
        );
    }
}
