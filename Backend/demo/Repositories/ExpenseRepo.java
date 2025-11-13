package com.example.demo.Repositories;

import com.example.demo.Modules.Category;
import com.example.demo.Modules.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Long> {
    Optional<Expense> findById(Long id);

    void deleteById(Long id);

    List<Expense> findByCategory(Category category);

}
