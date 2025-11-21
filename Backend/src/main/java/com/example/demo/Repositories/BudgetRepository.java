package com.example.demo.Repositories;

import com.example.demo.Modules.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {
    Budget findByUserIdAndMonthAndYear(long userId, int month, long year);

}
