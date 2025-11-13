package com.example.demo.Repositories;

import com.example.demo.Modules.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    

    boolean findByEmail(@NotBlank @Size(max = 50) @Email String email);

    Employee findByEmployeeName(String username);

    Optional<Employee> findById(Long userid);
}
