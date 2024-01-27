package com.banking.system.vsbank.api.service;

import com.banking.system.vsbank.api.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OperationService {
    List<Transaction> getTransactionHistory(int clientId);
}
