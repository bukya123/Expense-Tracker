package com.example.demo.Services;


import com.example.demo.ControllerAdvice.APIException;
import com.example.demo.DTOs.ExpenseRequestDTO;
import com.example.demo.Modules.Category;
import com.example.demo.Modules.Employee;
import com.example.demo.Modules.Expense;
import com.example.demo.Repositories.CategoryRepo;
import com.example.demo.Repositories.EmployeeRepo;
import com.example.demo.Repositories.ExpenseRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImp implements ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Expense addExpense(ExpenseRequestDTO expenseRequestDTO,Long userid) {
        Optional<Employee> employee=employeeRepo.findById(userid);
        if(!employee.isPresent()){
            throw new APIException("Employee not found");
        }


        Category category = categoryRepo.findByCategoryName(expenseRequestDTO.getCategoryName());
        if(category==null){
            Category category1=new Category();
            category1.setCategoryName(expenseRequestDTO.getCategoryName());
            categoryRepo.save(category1);
            category=category1;
        }

        Expense expense =modelMapper.map(expenseRequestDTO,Expense.class);
        expense.setCategory(category);
        expense.setEmployee(employee.get());
        expenseRepo.save(expense);
        employeeRepo.save(employee.get());
        return expense;
    }

    @Override
    public List<ExpenseRequestDTO> getAllExpenses() {
        List<Expense> expenseList=expenseRepo.findAll();
        List<ExpenseRequestDTO> expenseRequestDTOList=new ArrayList<>();
        for(Expense expense:expenseList){
            ExpenseRequestDTO expenseRequestDTO=new ExpenseRequestDTO();
            expenseRequestDTO.setCategoryName(expense.getCategory().getCategoryName());
            expenseRequestDTO.setAmount(expense.getAmount());
            expenseRequestDTO.setId(expense.getId());
            expenseRequestDTO.setDate(expense.getDate());
            expenseRequestDTO.setDescription(expense.getDescription());
            expenseRequestDTOList.add(expenseRequestDTO);
        }
        return expenseRequestDTOList;
    }

    @Override
    public Expense getExpense(Long id) {
        Optional<Expense> expense=expenseRepo.findById(id);
        if(!expense.isPresent()){
            throw new RuntimeException("Expense not found");
        }
        return expense.get();
    }

    @Override
    public void remove(Long id) {
        Optional<Expense> expense=expenseRepo.findById(id);
        if(!expense.isPresent()){
            throw new RuntimeException("Expense not found");
        }
        expenseRepo.deleteById(id);
    }

    @Override
    public Expense update( ExpenseRequestDTO expenseRequestDTO,Long id) {
        Category category = categoryRepo.findByCategoryName(expenseRequestDTO.getCategoryName());
        if(category==null){
            throw new RuntimeException("Category not found");
        }
        Optional<Expense> OptionalExpense=expenseRepo.findById(id);
        if(!OptionalExpense.isPresent()){
            throw new RuntimeException("Expense not found");
        }

        Expense expense1=OptionalExpense.get();
        expense1.setDescription(expenseRequestDTO.getDescription());
        expense1.setDate(expenseRequestDTO.getDate());
        expense1.setAmount(expenseRequestDTO.getAmount());
        return expenseRepo.save(expense1);
    }

    @Override
    public List<ExpenseRequestDTO> getExpenseByCategory(String categoryName) {
        Category category = categoryRepo.findByCategoryName(categoryName);
        if(category==null){
            throw new RuntimeException("Category not found");
        }
        List<Expense>expenseList=expenseRepo.findByCategory(category);
        List<ExpenseRequestDTO> expenseRequestDTOList=new ArrayList<>();
        for(Expense expense:expenseList){
            ExpenseRequestDTO expenseRequestDTO=new ExpenseRequestDTO();
            expenseRequestDTO.setCategoryName(expense.getCategory().getCategoryName());
            expenseRequestDTO.setAmount(expense.getAmount());
            expenseRequestDTO.setId(expense.getId());
            expenseRequestDTO.setDate(expense.getDate());
            expenseRequestDTO.setDescription(expense.getDescription());
            expenseRequestDTOList.add(expenseRequestDTO);
        }
        return expenseRequestDTOList;
    }
}
