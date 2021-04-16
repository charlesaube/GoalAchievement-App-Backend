package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.DTO.ObjectifDTO;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.Model.entities.User;
import com.example.projet_web.repositories.interfaces.IObjectifRepository;
import com.example.projet_web.services.ICategoryService;
import com.example.projet_web.services.IObjectifService;
import com.example.projet_web.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectifService implements IObjectifService {
    private final IObjectifRepository objectifRepository;
    private final ICategoryService categoryService;
    private final IUserService userService;

    @Autowired
    public ObjectifService(IObjectifRepository objectifRepository, ICategoryService categoryService, IUserService userService) {
        this.objectifRepository = objectifRepository;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public Optional<Objectif> readOne(Long Id) {
        return objectifRepository.findById(Id);
    }

    @Override
    public List<Objectif> readAll() {
        return objectifRepository.findAll();
    }

    public Objectif create(Objectif objectif){
        return objectifRepository.save(objectif);
    }


    @Override
    public List<Objectif> findObjectifSortByMostRecent() {
        return objectifRepository.findObjectifSortByMostRecent();
    }

    @Override
    public Long countAll() {
        return objectifRepository.countAll();
    }

    @Override
    public List<Objectif> findObjectifAccomplished() {
        return objectifRepository.findObjectifAccomplished();
    }

    @Override
    public void delete(Long objectifId) {
        objectifRepository.deleteById(objectifId);
    }

    @Override
    public Objectif save(ObjectifDTO objectifDTO) {
        Category category = categoryService.readOne(objectifDTO.getCategoryId()).get();
        User user = userService.readOne(objectifDTO.getUserId()).get();
        Objectif objectif = new Objectif();
        objectif.setObjectifName(objectifDTO.getObjectifName());
        objectif.setCategory(category);
        objectif.setEndDate(objectifDTO.getEndDate());
        objectif.setStartDate(objectifDTO.getStartDate());
        objectif.setIsAchieved(objectifDTO.getIsAchieved());
        objectif.setUser(user);

        return objectifRepository.save(objectif);
    }
}
