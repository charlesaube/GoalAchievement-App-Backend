package com.example.projet_web.Model.entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category")
@NamedQueries({
        @NamedQuery(name = "Category.getCategoryById", query = "select c from Category c where c.categoryId = :categoryId")
        ,@NamedQuery(name = "Category.getAllCategories", query = "select c from Category c")

})
@NoArgsConstructor //Lombok
@AllArgsConstructor
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "image_path")
    private String imagePath;

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
