package com.example.projet_web.repositories.interfaces;

import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllCategories();
}
