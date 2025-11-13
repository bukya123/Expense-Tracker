package com.example.demo.Controllers;


import com.example.demo.DTOs.TenantRequestDTO;
import com.example.demo.Modules.Tenant;
import com.example.demo.Services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/admin")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("/add")
    public ResponseEntity<Tenant> addTenant(@RequestBody TenantRequestDTO tenantRequestDTO) {
        Tenant tenant=tenantService.addTenant(tenantRequestDTO);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Tenant tenant=tenantService.fetchTenantById(id);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }
}
