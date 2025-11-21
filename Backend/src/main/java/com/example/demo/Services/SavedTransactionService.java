package com.example.demo.Services;

import com.example.demo.DTOs.requests.SavedTransactionRequestDto;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.exceptions.TransactionNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.UserServiceLogicException;
import org.springframework.http.ResponseEntity;

public interface SavedTransactionService {
    ResponseEntity<ApiResponseDto<?>> createSavedTransaction(SavedTransactionRequestDto requestDto) throws UserServiceLogicException, UserNotFoundException;
    ResponseEntity<ApiResponseDto<?>> addSavedTransaction(long savedTransactionId) throws UserServiceLogicException, TransactionNotFoundException;
    ResponseEntity<ApiResponseDto<?>> editSavedTransaction(long savedTransactionId, SavedTransactionRequestDto requestDto) throws UserServiceLogicException, TransactionNotFoundException;
    ResponseEntity<ApiResponseDto<?>> deleteSavedTransaction(long savedTransactionId) throws UserServiceLogicException, TransactionNotFoundException;
    ResponseEntity<ApiResponseDto<?>> skipSavedTransaction(long savedTransactionId) throws UserServiceLogicException, TransactionNotFoundException;
    ResponseEntity<ApiResponseDto<?>> getAllTransactionsByUser(long userId) throws UserServiceLogicException, UserNotFoundException;
    ResponseEntity<ApiResponseDto<?>> getAllTransactionsByUserAndMonth(long userId) throws UserServiceLogicException, UserNotFoundException;
    ResponseEntity<ApiResponseDto<?>> getSavedTransactionById(long savedTransactionId) throws UserServiceLogicException, TransactionNotFoundException;
}
