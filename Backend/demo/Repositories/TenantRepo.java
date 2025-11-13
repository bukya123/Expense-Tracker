package com.example.demo.Repositories;

import com.example.demo.Modules.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepo extends JpaRepository<Tenant,Long> {
    Tenant findByName(String name);
}
