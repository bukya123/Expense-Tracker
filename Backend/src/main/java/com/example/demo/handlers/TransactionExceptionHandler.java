package com.example.demo.handlers;


import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Enums.ApiResponseStatus;
import com.example.demo.exceptions.TransactionNotFoundException;
import com.example.demo.exceptions.TransactionServiceLogicException;
import com.example.demo.exceptions.TransactionTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TransactionExceptionHandler {
    @ExceptionHandler(value = TransactionServiceLogicException.class)
    public ResponseEntity<ApiResponseDto<String>> TransactionServiceLogicExceptionHandler(TransactionServiceLogicException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new ApiResponseDto<>(ApiResponseStatus.FAILED, HttpStatus.BAD_REQUEST, exception.getMessage())
                );
    }

    @ExceptionHandler(value = TransactionNotFoundException.class)
    public ResponseEntity<ApiResponseDto<String>> TransactionNotFoundExceptionHandler(TransactionNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ApiResponseDto<>(ApiResponseStatus.FAILED, HttpStatus.NOT_FOUND, exception.getMessage())
                );
    }

    @ExceptionHandler(value = TransactionTypeNotFoundException.class)
    public ResponseEntity<ApiResponseDto<String>> TransactionTypeNotFoundExceptionHandler(TransactionTypeNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new ApiResponseDto<>(ApiResponseStatus.FAILED, HttpStatus.NOT_FOUND, exception.getMessage())
                );
    }
}