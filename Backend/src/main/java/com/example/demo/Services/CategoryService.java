package com.example.demo.Services;

import com.example.demo.DTOs.requests.CategoryRequestDto;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Modules.Category;
import com.example.demo.exceptions.CategoryAlreadyExistsException;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.CategoryServiceLogicException;
import com.example.demo.exceptions.TransactionTypeNotFoundException;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<ApiResponseDto<?>> getCategories();

    boolean existsCategory(int id);

    Category getCategoryById(int id) throws CategoryNotFoundException;

    ResponseEntity<ApiResponseDto<?>> addNewCategory(CategoryRequestDto categoryRequestDto)
            throws TransactionTypeNotFoundException, CategoryServiceLogicException, CategoryAlreadyExistsException;

    ResponseEntity<ApiResponseDto<?>> updateCategory(int categoryId, CategoryRequestDto categoryRequestDto)
            throws CategoryNotFoundException, TransactionTypeNotFoundException, CategoryServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> enableOrDisableCategory(int categoryId) throws CategoryServiceLogicException, CategoryNotFoundException;
}
