package com.banking.system.vsbank.api.service;

import com.banking.system.vsbank.api.entity.Account;
import com.banking.system.vsbank.api.entity.Client;
import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.exception.ResourceNotFoundException;
import com.banking.system.vsbank.api.repository.AccountRepository;
import com.banking.system.vsbank.api.repository.ClientRepository;
import com.banking.system.vsbank.api.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TransactionServiceTest {


    @Autowired
    TransactionService transactionService;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ClientRepository clientRepository;


    @BeforeEach
    public void setUp(){

        transactionRepository.deleteAll();
        clientRepository.deleteAll();
        accountRepository.deleteAll();


        clientRepository.save(Client.builder().id(1).name("Saif Ksibi").build());
        clientRepository.save(Client.builder().id(2).name("John Poor ").build());

        //two accounts for user 1
        accountRepository.save(Account.builder().idAccount(1).idOwner(1).balance(0).build());
        accountRepository.save(Account.builder().idAccount(2).idOwner(1).balance(100).build());
    }



    @Test
    public void testDepositWhenUserExists(){

        //call service
        Transaction tr1 = transactionService.performDeposit(1, Transaction.builder().transactionAmount(500).build());

        //check
        Assert.assertTrue(tr1.getTransactionAmount()==500);
        Assert.assertTrue(tr1.getIdTransactionClient()==1);
        Assert.assertTrue(tr1.getPostTransactionGlobalBalance()==500);

        Assert.assertTrue(accountRepository.findById(1).getBalance()==500);
    }


    @Test
    public void testDepositWhenAccountIsUnknown(){

        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            transactionService.performDeposit(999, Transaction.builder().transactionAmount(500).build());
        });

        String expectedMessage = "Unknown Account";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}