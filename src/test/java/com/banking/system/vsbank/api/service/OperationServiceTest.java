package com.banking.system.vsbank.api.service;


import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.exception.ResourceNotFoundException;
import com.banking.system.vsbank.api.repository.TransactionRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OperationServiceTest {

    @Autowired
    OperationService operationService;

    @Autowired
    TransactionRepository transactionRepository;


    @BeforeEach
    public void setUp(){
        transactionRepository.deleteAll();
    }

    @Test
    public void testGetHistoryWhenHistoryNotEmpty(){

        //prepare data in repository
        Transaction t1 = Transaction.builder().transactionDate(new Date()).idTransaction(1).idTransactionClient(1).type(TransactionType.DEPOSIT).postTransactionGlobalBalance(300).transactionAmount(100).build();
        Transaction t2 = Transaction.builder().transactionDate(new Date()).idTransaction(2).idTransactionClient(1).type(TransactionType.WITHDRAW).postTransactionGlobalBalance(200).transactionAmount(200).build();
        transactionRepository.save(t1);
        transactionRepository.save(t2);

        //call service
        List<Transaction> transactions = operationService.getTransactionHistory(1);

        //check
        Assert.assertTrue(transactions.size()==2);
    }




    @Test
    public void testGetHistoryWhenUnknownUser(){

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            operationService.getTransactionHistory(999);
        });

        String expectedMessage = "Unknown User";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }



}