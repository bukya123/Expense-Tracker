package com.example.demo.Services;


import com.example.demo.DTOs.requests.BudgetRequest;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Enums.ApiResponseStatus;
import com.example.demo.Modules.Budget;
import com.example.demo.Repositories.BudgetRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.UserServiceLogicException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class BudgetServiceImp implements BudgetService{
    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<ApiResponseDto<?>> createBudget(BudgetRequest budgetRequest) throws UserNotFoundException, UserServiceLogicException {
        if (!userRepository.existsById(budgetRequest.getUserId())) {
            throw new UserNotFoundException("User not found with id " + budgetRequest.getUserId());
        }
        try {
            Budget budget = budgetRepository.findByUserIdAndMonthAndYear(budgetRequest.getUserId(), LocalDate.now().getMonthValue(), LocalDate.now().getYear());
            if (budget == null){
                budget = new Budget(
                        budgetRequest.getUserId(), budgetRequest.getAmount(), LocalDate.now().getMonthValue(), LocalDate.now().getYear()
                );
            }
            else {
                budget.setAmount(budgetRequest.getAmount());
            }

            budgetRepository.save(budget);

            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponseDto<>(
                    ApiResponseStatus.SUCCESS,
                    HttpStatus.CREATED,
                    "Budget created successfully!"
            ));
        }catch (Exception e) {
            log.error("Failed to fetch All users: " + e.getMessage());
            throw new UserServiceLogicException("Failed to create budget: Try again later!");
        }

    }

    @Override
    public ResponseEntity<ApiResponseDto<?>> getBudgetByMonth(long userId, int month, long year) throws UserServiceLogicException {
        try {
            Budget budget = budgetRepository.findByUserIdAndMonthAndYear(userId, month, year);
            double amount = budget == null ? 0 : budget.getAmount();

            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDto<>(
                    ApiResponseStatus.SUCCESS,
                    HttpStatus.OK,
                    amount
            ));
        }catch (Exception e) {
            log.error("Failed to fetch budget amount: " + e.getMessage());
            throw new UserServiceLogicException("Failed to create budget: Try again later!");
        }
    }
}
