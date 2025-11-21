package com.example.demo.Controllers;


import com.example.demo.DTOs.requests.CategoryRequestDto;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Services.CategoryService;
import com.example.demo.Services.TransactionTypeService;
import com.example.demo.exceptions.CategoryAlreadyExistsException;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.CategoryServiceLogicException;
import com.example.demo.exceptions.TransactionTypeNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5185/")
@RestController
@RequestMapping("/ExpenseTracker/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> getAllCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/new")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> addNewCategory(@RequestBody @Valid CategoryRequestDto categoryRequestDto)
            throws CategoryServiceLogicException, TransactionTypeNotFoundException, CategoryAlreadyExistsException {
        return categoryService.addNewCategory(categoryRequestDto);
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> updateCategory(@Param("categoryId") int categoryId,
                                                            @RequestBody @Valid CategoryRequestDto categoryRequestDto)
            throws CategoryServiceLogicException, CategoryNotFoundException, TransactionTypeNotFoundException {
        return categoryService.updateCategory(categoryId, categoryRequestDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ApiResponseDto<?>> disableOrEnableCategory(@Param ("categoryId") int categoryId)
            throws CategoryServiceLogicException, CategoryNotFoundException {
        return categoryService.enableOrDisableCategory(categoryId);
    }

}
