package com.example.demo.Modules;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;
    private String employeeName;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    private Role role;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tenant tenant;


    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Expense> expenses;
}
