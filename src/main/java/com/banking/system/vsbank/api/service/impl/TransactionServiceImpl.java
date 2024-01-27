package com.banking.system.vsbank.api.service.impl;


import com.banking.system.vsbank.api.entity.Account;
import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.exception.ResourceNotFoundException;
import com.banking.system.vsbank.api.repository.AccountRepository;
import com.banking.system.vsbank.api.repository.TransactionRepository;
import com.banking.system.vsbank.api.service.TransactionService;
import com.banking.system.vsbank.api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.system.vsbank.api.constants.TransactionType;

import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Transaction performDeposit(int idAccount, Transaction transactionRequest) {


        Account accountById = accountRepository.findById(idAccount);
        if(null == accountById ){
            throw new ResourceNotFoundException("Unknown Account");
        }


        long currentBalance = accountById.getBalance();
        long depositAmount = transactionRequest.getTransactionAmount();
        long postTransactionBalance = currentBalance+depositAmount;


        accountById.setBalance(postTransactionBalance);


        accountRepository.update(accountById);

        Transaction transaction = Transaction
                .builder()
                .idTransaction(Utils.generateID())
                .idTransactionAccount(idAccount)
                .idTransactionClient(accountById.getIdOwner())
                .transactionAmount(depositAmount)
                .transactionDate(new Date())
                .type(TransactionType.DEPOSIT)
                .postTransactionGlobalBalance(postTransactionBalance)
                .build();

        transactionRepository.save(transaction);

        return transaction;


    }




}

