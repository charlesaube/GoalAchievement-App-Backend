package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.Coach;
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
}
