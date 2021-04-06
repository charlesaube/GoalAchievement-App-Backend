package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.CategoryDTO;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.services.implementation.CategoryService;
import com.example.projet_web.services.mappers.CategoryMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/category")
public class CategoryResource {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    public  CategoryResource(CategoryService categoryService, CategoryMapper categoryMapper){
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAll(){
        IEntityMapper<Category, CategoryDTO> mapper = new CategoryMapper();
        return this.categoryService.readAll().stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }
}
