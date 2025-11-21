package com.example.demo.Controllers;

import com.example.demo.DTOs.requests.ResetPasswordRequestDto;
import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Services.AuthService;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.UserServiceLogicException;
import com.example.demo.exceptions.UserVerificationFailedException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5185/")
@RestController
@RequestMapping("/ExpenseTracker/auth/forgotPassword")
public class ForgotPasswordController {

    @Autowired
    private AuthService authService;

    @GetMapping("/verifyEmail")
    public ResponseEntity<ApiResponseDto<?>> verifyEmail(@Param("email") String email)
            throws UserNotFoundException, UserServiceLogicException {
        return authService.verifyEmailAndSendForgotPasswordVerificationEmail(email);
    }

    @GetMapping("/verifyCode")
    public ResponseEntity<ApiResponseDto<?>> verifyCode(@Param("code") String code)
            throws UserVerificationFailedException, UserServiceLogicException {
        return authService.verifyForgotPasswordVerification(code);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<ApiResponseDto<?>> resetPassword(@RequestBody @Valid ResetPasswordRequestDto resetPasswordDto)
            throws UserNotFoundException, UserServiceLogicException {
        return authService.resetPassword(resetPasswordDto);
    }

    @GetMapping("/resendEmail")
    public ResponseEntity<ApiResponseDto<?>> resendEmail(@Param("email") String email)
            throws UserNotFoundException, UserServiceLogicException {
        return authService.verifyEmailAndSendForgotPasswordVerificationEmail(email);
    }
}
