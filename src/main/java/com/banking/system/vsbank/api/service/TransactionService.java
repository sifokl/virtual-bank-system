package com.banking.system.vsbank.api.service;

import com.banking.system.vsbank.api.entity.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    Transaction performDeposit(int idAccount, Transaction transactionRequest);

}