package com.example.demo.Services;

import com.example.demo.DTOs.responses.ApiResponseDto;
import com.example.demo.Modules.User;
import com.example.demo.exceptions.RoleNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.UserServiceLogicException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    boolean existsByUsername(String username);

    boolean existsByEmail(String Email);

    User findByEmail(String email) throws UserNotFoundException;

    ResponseEntity<ApiResponseDto<?>> getAllUsers(int pageNumber, int pageSize, String searchKey) throws RoleNotFoundException, UserServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> enableOrDisableUser(long userId) throws UserNotFoundException, UserServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> uploadProfileImg(String email, MultipartFile file) throws UserServiceLogicException, UserNotFoundException;

    ResponseEntity<ApiResponseDto<?>> getProfileImg(String email) throws UserNotFoundException, IOException, UserServiceLogicException;

    ResponseEntity<ApiResponseDto<?>> deleteProfileImg(String email) throws UserServiceLogicException, UserNotFoundException;
}
