package com.example.projet_web.Model.DTO;
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
    private String imagePath;
    public CategoryDTO(){}

    public CategoryDTO(Long categoryId, String categoryName, String imagePath) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.imagePath = imagePath;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
