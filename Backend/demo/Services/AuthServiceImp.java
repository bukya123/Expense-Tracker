package com.example.demo.Services;


import com.example.demo.ControllerAdvice.APIException;
import com.example.demo.Modules.AppRole;
import com.example.demo.Modules.Employee;
import com.example.demo.Modules.Role;
import com.example.demo.Modules.Tenant;
import com.example.demo.Repositories.EmployeeRepo;
import com.example.demo.Repositories.RoleRepo;
import com.example.demo.Repositories.TenantRepo;
import com.example.demo.Security.JWT.JwtUtils;
import com.example.demo.Security.JWTService.UserDetailsImp;
import com.example.demo.Security.Request.LoginRequest;
import com.example.demo.Security.Request.SignUpRequest;
import com.example.demo.Security.Response.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImp implements AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private TenantRepo tenantRepo;

    @Override
    public UserInfoResponse SignIn(LoginRequest loginRequest) {
        // it will authenticate and gives authentication object
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImp userDetailsImp=(UserDetailsImp)authentication.getPrincipal();

        List<String> roles = userDetailsImp.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        UserInfoResponse userInfoResponse=new UserInfoResponse();
        userInfoResponse.setId(userDetailsImp.getId());
        userInfoResponse.setUsername(userDetailsImp.getUsername());
        userInfoResponse.setEmail(userDetailsImp.getEmail());
        userInfoResponse.setJwtToken(jwtUtils.generateJwtCookie(userDetailsImp).toString());
        userInfoResponse.setRoles(roles);
        return userInfoResponse;
    }

    @Override
    public Employee SignUp(SignUpRequest signUpRequest) {
        Tenant tenant=tenantRepo.findByName(signUpRequest.getTenantName());
        if(tenant==null){
            throw new APIException("Tenant is not registered with this name");
        }

        List<Employee>employees=employeeRepo.findAll();
        for(Employee employee:employees){
            if(employee.getEmployeeName().equals(signUpRequest.getUsername())){
                throw new APIException("Username is already taken");
            }else if(employee.getEmail().equals(signUpRequest.getEmail())){
                throw new APIException("Email is already taken");
            }
        }


        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // Create new user's account
        Employee user = new Employee();
        user.setEmployeeName(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setTenant(tenant);

        String strRoles = signUpRequest.getRoleName();

        if (strRoles==null) {
            Role role = roleRepo.findByRoleName(AppRole.ROLE_EMPLOYEE);
            if(role==null){
                role=new Role();
                role.setRoleName(AppRole.ROLE_EMPLOYEE);
            }
            roleRepo.save(role);
            user.setRole(role);
            employeeRepo.save(user);
        } else {
            if(strRoles.equals("employee")){
                Role role = roleRepo.findByRoleName(AppRole.ROLE_EMPLOYEE);
                if(role==null){
                    role=new Role();
                    role.setRoleName(AppRole.ROLE_EMPLOYEE);
                    roleRepo.save(role);
                }
                user.setRole(role);
                employeeRepo.save(user);
            }else{
                Role role = roleRepo.findByRoleName(AppRole.ROLE_MANAGER);
                if(role==null){
                    role=new Role();
                    role.setRoleName(AppRole.ROLE_MANAGER);
                    roleRepo.save(role);
                }
                user.setRole(role);
                employeeRepo.save(user);
            }


        }


        return user;


    }
}
