package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IObjectifRepository extends JpaRepository<Objectif,Long> {
    List<Objectif> findAll();
    //Objectif findObjectifById(Long id);
    List<Objectif> findObjectifSortByMostRecent();
    Long countAll();
    List<Objectif> findObjectifAccomplished();
    List<Objectif> findObjectifByUserId(long userId);

}
