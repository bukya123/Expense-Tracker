package com.example.demo.Services;


import com.example.demo.DTOs.requests.TransactionRequestDto;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.exceptions.TransactionNotFoundException;
import com.example.demo.exceptions.TransactionServiceLogicException;
import com.example.demo.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;

public interface TransactionService {
    ResponseEntity<ApiResponseDto<?>> addTransaction(TransactionRequestDto transactionRequestDto)
            throws UserNotFoundException, CategoryNotFoundException, TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getTransactionById(Long TransactionId)
            throws TransactionNotFoundException;

    ResponseEntity<ApiResponseDto<?>> updateTransaction(Long transactionId, TransactionRequestDto transactionRequestDto)
            throws TransactionNotFoundException, UserNotFoundException, CategoryNotFoundException, TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> deleteTransaction(Long transactionId) throws TransactionNotFoundException, TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getAllTransactions(int pageNumber, int pageSize, String searchKey) throws TransactionServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> getTransactionsByUser(String email, int pageNumber, int pageSize, String searchKey, String sortField, String sortDirec, String transactionType) throws UserNotFoundException, TransactionServiceLogicException;


}
