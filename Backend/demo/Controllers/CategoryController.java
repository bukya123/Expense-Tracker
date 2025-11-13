package com.example.demo.Controllers;


import com.example.demo.Modules.Category;
import com.example.demo.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/public/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category>addCategory(@RequestBody Category category){
        Category category1=categoryService.addCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Category>> fetchCategory(){
        List<Category>categoryList=categoryService.getCategory();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Category> fetchCategoryById(@PathVariable Long id){
        Category category=categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id){
        Category category1=categoryService.updateCategoryById(category,id);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.remove(id);
        return new ResponseEntity<>("Category has been deleted", HttpStatus.OK);
    }
}
