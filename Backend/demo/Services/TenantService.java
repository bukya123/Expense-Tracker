package com.example.demo.Services;

import com.example.demo.DTOs.TenantRequestDTO;
import com.example.demo.Modules.Tenant;

public interface TenantService {

    Tenant addTenant(TenantRequestDTO tenantRequestDTO);

    Tenant fetchTenantById(Long id);
}
