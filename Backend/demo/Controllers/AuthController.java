package com.example.demo.Controllers;

import com.example.demo.Modules.Employee;
import com.example.demo.Repositories.EmployeeRepo;
import com.example.demo.Repositories.RoleRepo;
import com.example.demo.Security.Request.LoginRequest;
import com.example.demo.Security.Request.SignUpRequest;
import com.example.demo.Security.Response.UserInfoResponse;
import com.example.demo.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    RoleRepo roleRepo;


    @PostMapping("/SignIn")
    public ResponseEntity<UserInfoResponse> SignIn(@RequestBody LoginRequest loginRequest) {
        UserInfoResponse userInfoResponse =authService.SignIn(loginRequest);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, userInfoResponse.getJwtToken()).body(userInfoResponse);
    }


    @PostMapping("/SignUp")
    public ResponseEntity<Employee> SignUp(@RequestBody SignUpRequest signUpRequest) {
        Employee appUser=authService.SignUp(signUpRequest);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
}
