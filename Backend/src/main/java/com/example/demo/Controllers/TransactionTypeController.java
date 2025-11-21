package com.example.demo.Controllers;

import com.example.demo.DTOs.requests.TransactionTypeRequestDto;
import com.example.demo.Modules.TransactionType;
import com.example.demo.Services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5185/")
@RestController
@RequestMapping("/ExpenseTracker/transactiontype")
public class TransactionTypeController {

    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactions();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public TransactionType createTransactionType(@RequestBody TransactionTypeRequestDto transactionTypeRequestDto) {
        return transactionTypeService.create(transactionTypeRequestDto);

    }
}
