package com.example.projet_web.services.mappers;

import com.example.projet_web.Model.DTO.CategoryDTO;
import com.example.projet_web.Model.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper implements IEntityMapper<Category, CategoryDTO> {
    @Override
    public CategoryDTO entityToDTO(Category category) {
        return new CategoryDTO(category.getCategoryId(),
                category.getCategoryName(),
                category.getImagePath());
    }
}
