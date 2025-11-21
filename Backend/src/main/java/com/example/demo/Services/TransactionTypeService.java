package com.example.demo.Services;

import com.example.demo.DTOs.requests.TransactionTypeRequestDto;
import com.example.demo.Modules.TransactionType;
import com.example.demo.exceptions.TransactionTypeNotFoundException;

import java.util.List;

public interface TransactionTypeService {
    List<TransactionType> getAllTransactions();

    boolean existsByTransactionTypeId(int transactionTypeId);

    TransactionType getTransactionById(int transactionTypeId) throws TransactionTypeNotFoundException;

    TransactionType create(TransactionTypeRequestDto transactionTypeRequestDto);

}
