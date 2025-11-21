package com.example.demo.Services;

import com.example.demo.DTOs.responses.ApiResponseDto;
import org.springframework.http.ResponseEntity;

public interface ReportService {
    ResponseEntity<ApiResponseDto<?>> getTotalByTransactionTypeAndUser(Long userId, int transactionTypeId, int month, int year);

    ResponseEntity<ApiResponseDto<?>> getTotalNoOfTransactionsByUser(Long userId, int month, int year);

    ResponseEntity<ApiResponseDto<?>> getTotalExpenseByCategoryAndUser(String email, int categoryId, int month, int year);

    ResponseEntity<ApiResponseDto<?>> getMonthlySummaryByUser(String email);
}
