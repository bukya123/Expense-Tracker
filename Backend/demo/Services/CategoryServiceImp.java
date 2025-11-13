package com.example.demo.Services;

import com.example.demo.Modules.Category;
import com.example.demo.Repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void remove(Long id) {
        Optional<Category> category=categoryRepo.findById(id);
        if(!category.isPresent()){
            throw new RuntimeException("Category Not Found");
        }
        categoryRepo.delete(category.get());
    }

    @Override
    public Category addCategory(Category category) {
        Category category1=categoryRepo.findByCategoryName(category.getCategoryName());
        if(category1==null){
            category1=categoryRepo.save(category);
        }
        return category1;
    }

    @Override
    public List<Category> getCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category=categoryRepo.findById(id);
        if(!category.isPresent()){
            throw new RuntimeException("Category Not Found");
        }
        return category.get();
    }

    @Override
    public Category updateCategoryById(Category category, Long id) {
        Optional<Category>category2=categoryRepo.findById(id);
        if(!category2.isPresent()){
            throw new RuntimeException("Category Not Found");
        }
        Category category1=category2.get();
        category1.setCategoryName(category.getCategoryName());
        return categoryRepo.save(category1);
    }

}
