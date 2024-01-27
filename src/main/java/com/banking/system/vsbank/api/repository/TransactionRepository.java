package com.banking.system.vsbank.api.repository;

import com.banking.system.vsbank.api.entity.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends TRepository<Transaction> {
    List<Transaction> getTransactionsByClientId(int clientId);
}
