package com.example.demo.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantRequestDTO {
    private Long id;
    private String name;
    private String email;
}
