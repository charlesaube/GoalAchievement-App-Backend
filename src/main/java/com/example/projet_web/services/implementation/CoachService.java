package com.example.projet_web.services.implementation;

import antlr.CommonASTWithHiddenTokens;
import com.example.projet_web.Model.DTO.CoachDTO;
import com.example.projet_web.Model.entities.Coach;
import com.example.projet_web.Model.entities.Comment;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.repositories.interfaces.ICoachRepository;
import com.example.projet_web.services.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CoachService implements ICoachService {

    private final ICoachRepository coachRepository;
    @Autowired
    public CoachService(ICoachRepository coachRepository){this.coachRepository = coachRepository;}

    public Coach create(Coach coach){
        return  coachRepository.save(coach);
    }

    public Optional<Coach> readOne(Long coachId){
        return  coachRepository.findById(coachId);
    }

    public List<Coach> readAll(){
        return  coachRepository.findAll();
    }

    public void delete(Long coachId){
        coachRepository.deleteById(coachId);
    }

    public List<Coach> getAllCoachByFirstNameSubString(String subStr){
        return  coachRepository.findAllCoachByFirstNameSubString(subStr);
    }

    @Override
    public Coach save(CoachDTO coachDTO) {
        Coach coach = new Coach();

        coach.setDescription(coachDTO.getDescription());
        coach.setEmail(coachDTO.getEmail());
        coach.setGender(coachDTO.getGender());
        coach.setPassword(coachDTO.getPassword());
        coach.setFirstName(coachDTO.getFirstName());
        coach.setLastName(coachDTO.getLastName());
        return coachRepository.save(coach);
    }

    @Override
    public Coach update(CoachDTO coachDTO) {
        Optional<Coach> storedOptional = readOne(coachDTO.getCoachId());

        if (storedOptional.isPresent()) {
            Coach stored = storedOptional.get();

            stored.setDescription(coachDTO.getDescription());
            stored.setEmail(coachDTO.getEmail());
            stored.setGender(coachDTO.getGender());
            stored.setPassword(coachDTO.getPassword());
            stored.setFirstName(coachDTO.getFirstName());
            stored.setLastName(coachDTO.getLastName());
            return coachRepository.save(stored);
        }

        return null;
    }
}
