package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.Objectif;
import com.example.projet_web.repositories.interfaces.IObjectifRepository;
import com.example.projet_web.services.IObjectifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObjectifService implements IObjectifService {
    private final IObjectifRepository objectifRepository;

    @Autowired
    public ObjectifService(IObjectifRepository objectifRepository) {
        this.objectifRepository = objectifRepository;
    }

    @Override
    public Optional<Objectif> readOne(Long Id) {
        return objectifRepository.findById(Id);
    }

    @Override
    public List<Objectif> readAll() {
        return objectifRepository.findAll();
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
}
