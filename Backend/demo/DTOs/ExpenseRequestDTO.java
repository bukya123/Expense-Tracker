package com.example.demo.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExpenseRequestDTO {
    private Long id;
    private Double amount;
    private String description;
    private String categoryName;
    private Date date;
}
