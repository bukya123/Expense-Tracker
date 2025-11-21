package com.example.demo.DTOs.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BudgetRequest {
    long userId;
    double amount;
}