package com.example.demo.Repositories;

import com.example.demo.Modules.Category;
import com.example.demo.Modules.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    boolean existsByCategoryNameAndTransactionType(String categoryName, TransactionType transactionType);
}
