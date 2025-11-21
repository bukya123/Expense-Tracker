package com.example.demo.Services;


import com.example.demo.DTOs.requests.TransactionTypeRequestDto;
import com.example.demo.Enums.ETransactionType;
import com.example.demo.Modules.TransactionType;
import com.example.demo.Repositories.TransactionTypeRepository;
import com.example.demo.exceptions.TransactionTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServiceImp implements TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Override
    public List<TransactionType> getAllTransactions() {
        return transactionTypeRepository.findAll();
    }

    @Override
    public boolean existsByTransactionTypeId(int transactionTypeId) {
        return transactionTypeRepository.existsById((long) transactionTypeId);
    }

    @Override
    public TransactionType getTransactionById(int transactionTypeId) throws TransactionTypeNotFoundException {
        return transactionTypeRepository.findById((long) transactionTypeId).orElseThrow(
                () -> new TransactionTypeNotFoundException("Transaction type not found with id " + transactionTypeId)
        );
    }

    @Override
    public TransactionType create(TransactionTypeRequestDto transactionTypeRequestDto) {


        TransactionType transactionType = new TransactionType();
        if(transactionTypeRequestDto.getTransactionType().equals("income")){
            transactionType.setTransactionTypeName(ETransactionType.TYPE_INCOME);
        }else if(transactionTypeRequestDto.getTransactionType().equals("expense")){
            transactionType.setTransactionTypeName(ETransactionType.TYPE_EXPENSE);
        }
        return transactionTypeRepository.save(transactionType);

    }


}
