package com.example.demo.DTOs.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserResponseDto {

    private Long id;

    private String username;

    private String email;

    private boolean enabled;

    private Double expense;

    private Double income;

    private Integer noOfTransactions;


}
