package com.banking.system.vsbank.api.repository.impl;


import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private List<Transaction> transactions;

    @PostConstruct
    private void populateRepository(){
        transactions = new ArrayList<>();
        // add some data to List

    }


    @Override
    public Transaction findById(int id) {
        Transaction transactionById =  transactions.stream().flatMap(s -> Stream.ofNullable(s)).filter(tr->tr.getIdTransaction()==id).findAny()
                .orElse(null);
        return transactionById;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public boolean save(Transaction transaction) {
        return transactions.add(transaction);
    }

    public List<Transaction> getTransactionsByClientId(int clientId){
        List<Transaction> transactionsByClientId =  transactions.stream().flatMap(s -> Stream.ofNullable(s)).filter(tr->tr.getIdTransactionClient()==clientId).collect(Collectors.toList());
        return transactionsByClientId;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> list) {
        return null;
    }

    @Override
    public boolean update(Transaction transaction) {
        return true;
    }

    @Override
    public boolean deleteAll() {
        transactions.clear();
        return true;
    }
}

