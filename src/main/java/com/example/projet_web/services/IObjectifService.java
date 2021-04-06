package com.example.projet_web.services;

import com.example.projet_web.Model.entities.Objectif;

import java.util.List;
import java.util.Optional;

public interface IObjectifService {

    Optional<Objectif> readOne(Long Id);
    List<Objectif> readAll();
    List<Objectif> findObjectifSortByMostRecent();
    Long countAll();
    List<Objectif> findObjectifAccomplished();
}
