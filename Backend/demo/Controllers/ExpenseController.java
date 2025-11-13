package com.example.demo.Controllers;


import com.example.demo.DTOs.ExpenseRequestDTO;
import com.example.demo.Modules.Expense;
import com.example.demo.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/expense")
public class ExpenseController {

    @Autowired
    public ExpenseService expenseService;

    @PostMapping("/add/{userid}")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequestDTO expenseRequestDTO,@PathVariable Long userid) {
        Expense expense1=expenseService.addExpense(expenseRequestDTO,userid);
        return new ResponseEntity<>(expense1, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ExpenseRequestDTO>> getAllExpense() {
        List<ExpenseRequestDTO>expenseList=expenseService.getAllExpenses();
        return new ResponseEntity<>(expenseList, HttpStatus.OK);

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Expense> getExpense(@PathVariable Long id) {
        Expense expense=expenseService.getExpense(id);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @GetMapping("/get/keyword/{keyword}")
    public ResponseEntity<List<ExpenseRequestDTO>> getExpenseByCategoryName(@PathVariable String keyword) {
        List<ExpenseRequestDTO>expense=expenseService.getExpenseByCategory(keyword);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }


    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.remove(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<Expense> updateExpense( @RequestBody ExpenseRequestDTO expenseRequestDTO,@PathVariable Long id) {
        Expense expense1=expenseService.update(expenseRequestDTO,id);
        return new ResponseEntity<>(expense1, HttpStatus.OK);
    }

}
