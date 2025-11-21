package com.example.demo.dataSeeders;

import com.example.demo.Enums.ETransactionType;
import com.example.demo.Modules.TransactionType;
import com.example.demo.Repositories.TransactionTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TransactionTypeDataSeeder {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @EventListener
    @Transactional
    public void LoadTransactionTypes(ContextRefreshedEvent event) {

        List<ETransactionType> transactionTypes = Arrays.stream(ETransactionType.values()).toList();

        for(ETransactionType eTransactionType: transactionTypes) {
            if (!transactionTypeRepository.existsByTransactionTypeName(eTransactionType)) {
                transactionTypeRepository.save(new TransactionType(eTransactionType));
            }
        }

    }
}
