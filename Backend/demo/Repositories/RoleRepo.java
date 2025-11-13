package com.example.demo.Repositories;

import com.example.demo.Modules.AppRole;
import com.example.demo.Modules.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(AppRole appRole);
}
