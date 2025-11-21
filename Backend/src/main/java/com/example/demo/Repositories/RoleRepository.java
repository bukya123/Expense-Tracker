package com.example.demo.Repositories;

import com.example.demo.Enums.ERole;
import com.example.demo.Modules.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
    boolean existsByName(ERole name);
}
