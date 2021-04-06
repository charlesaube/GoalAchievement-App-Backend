package com.example.projet_web.services;

import com.example.projet_web.Model.entities.Achievement;
import com.example.projet_web.Model.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    Category create(Category category);

    Optional<Category> readOne(Long categoryId);

    List<Category> readAll();

}
