package com.example.demo.Services;


import com.example.demo.DTOs.ExpenseRequestDTO;
import com.example.demo.Modules.Expense;

import java.util.List;

public interface ExpenseService {
    Expense addExpense(ExpenseRequestDTO expenseRequestDTO,Long userid);

    List<ExpenseRequestDTO> getAllExpenses();

    Expense getExpense(Long id);

    void remove(Long id);

    Expense update(ExpenseRequestDTO expenseRequestDTO,Long id);

    List<ExpenseRequestDTO> getExpenseByCategory(String categoryName);

}
