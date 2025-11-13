package com.example.demo.Services;

import com.example.demo.Modules.Category;

import java.util.List;

public interface CategoryService {
     void remove(Long id);


    Category addCategory(Category category);

    List<Category> getCategory();

    Category getCategoryById(Long id);

    Category updateCategoryById(Category category, Long id);
}
