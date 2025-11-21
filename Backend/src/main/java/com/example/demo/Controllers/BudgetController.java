package com.example.demo.Controllers;

import com.example.demo.DTOs.requests.BudgetRequest;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Services.BudgetService;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.UserServiceLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5185/")
@RestController
@RequestMapping("/ExpenseTracker/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> createBudget(@RequestBody BudgetRequest budgetRequest)
            throws UserNotFoundException, UserServiceLogicException {
        return budgetService.createBudget(budgetRequest);
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<ApiResponseDto<?>> getBudgetByMonth(@Param("userId") long userId,
                                                              @Param("month") int month,
                                                              @Param("year") long year)
            throws UserServiceLogicException {
        return budgetService.getBudgetByMonth(userId, month, year);
    }
}