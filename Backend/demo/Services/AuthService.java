package com.example.demo.Services;

import com.example.demo.Modules.Employee;
import com.example.demo.Security.Request.LoginRequest;
import com.example.demo.Security.Request.SignUpRequest;
import com.example.demo.Security.Response.UserInfoResponse;

public interface AuthService {
    UserInfoResponse SignIn(LoginRequest loginRequest);

    Employee SignUp(SignUpRequest signUpRequest);
}
