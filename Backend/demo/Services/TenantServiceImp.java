package com.example.demo.Services;

import com.example.demo.ControllerAdvice.APIException;
import com.example.demo.DTOs.TenantRequestDTO;
import com.example.demo.Modules.Tenant;
import com.example.demo.Repositories.TenantRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TenantServiceImp implements TenantService {
    @Autowired
    private TenantRepo tenantRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Tenant addTenant(TenantRequestDTO tenantRequestDTO) {
        Tenant tenant=tenantRepo.findByName(tenantRequestDTO.getName());
        System.out.println("hi-----");
        if(tenant!=null){
            throw new APIException("Tenant already exists");
        }
        System.out.println("hi-----"+ (tenantRequestDTO.getName()));
        Tenant newTenant=modelMapper.map(tenantRequestDTO, Tenant.class);
        return tenantRepo.save(newTenant);

    }

    @Override
    public Tenant fetchTenantById(Long id) {
        Optional<Tenant> tenant=tenantRepo.findById(id);
        if(!tenant.isPresent()){
            throw new APIException("Tenant not found");
        }
        return tenant.get();

    }
}
