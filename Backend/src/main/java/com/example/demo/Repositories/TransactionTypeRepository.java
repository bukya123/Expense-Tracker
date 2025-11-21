package com.example.demo.Repositories;

import com.example.demo.Enums.ETransactionType;
import com.example.demo.Modules.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType,Long> {
    Optional<TransactionType> findById(Long id);
    TransactionType findByTransactionTypeName(ETransactionType transactionTypeName);
    boolean existsByTransactionTypeName(ETransactionType transactionTypeName);
}
