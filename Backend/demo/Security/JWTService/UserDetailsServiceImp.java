package com.example.demo.Security.JWTService;

import com.example.demo.Modules.Employee;
import com.example.demo.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee appUser=employeeRepo.findByEmployeeName(username);
        if(appUser==null){
            throw new UsernameNotFoundException(username);
        }
        return UserDetailsImp.build(appUser);
    }
}
