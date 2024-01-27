package com.banking.system.vsbank.api.service.impl;

import com.banking.system.vsbank.api.entity.Client;
import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.exception.ResourceNotFoundException;
import com.banking.system.vsbank.api.repository.ClientRepository;
import com.banking.system.vsbank.api.repository.TransactionRepository;
import com.banking.system.vsbank.api.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Transaction> getTransactionHistory(int id) {

        Client clientById = clientRepository.findById(id);
        if (null == clientById) throw new ResourceNotFoundException("Unknown User");

        List<Transaction> transactionsByClientId = transactionRepository.getTransactionsByClientId(id);
        return transactionsByClientId;
    }
}
