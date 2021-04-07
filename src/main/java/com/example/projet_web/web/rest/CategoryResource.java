package com.example.projet_web.web.rest;

import com.example.projet_web.Model.DTO.CategoryDTO;
import com.example.projet_web.Model.entities.Category;
import com.example.projet_web.services.implementation.CategoryService;
import com.example.projet_web.services.mappers.CategoryMapper;
import com.example.projet_web.services.mappers.IEntityMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/all")
    public List<CategoryDTO> getAll(){
        IEntityMapper<Category, CategoryDTO> mapper = new CategoryMapper();
        return this.categoryService.readAll().stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable long id) {
        Optional<Category> category = categoryService.readOne(id);
        System.out.println(category.get().getCategoryName());
        Optional<CategoryDTO> categoryDTO = category.map(categoryMapper::entityToDTO);
        return categoryDTO.isPresent() ? new ResponseEntity<>(categoryDTO.get(),
                HttpStatus.OK) : new ResponseEntity<>("Customer Id not found", HttpStatus.NOT_FOUND);

    }


}
