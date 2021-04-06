package com.example.projet_web.services.implementation;

import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.repositories.interfaces.ICategoryRepository;
import com.example.projet_web.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private  final ICategoryRepository categoryRepository;
    @Autowired
    public CategoryService(ICategoryRepository categoryRepository){this.categoryRepository = categoryRepository;}

    public Category create(Category category){
        return  categoryRepository.save(category);
    }

    public Optional<Category> readOne(Long categoryId){
        return  categoryRepository.findById(categoryId);
    }

    public List<Category> readAll(){
        return  categoryRepository.findAllCategories();
    }

}
