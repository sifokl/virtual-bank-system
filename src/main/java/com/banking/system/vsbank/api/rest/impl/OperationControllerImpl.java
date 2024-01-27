package com.banking.system.vsbank.api.rest.impl;

import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.rest.OperationController;
import com.banking.system.vsbank.api.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationControllerImpl implements OperationController {

    @Autowired
    OperationService operationService;


    @Override
    public ResponseEntity<List<Transaction>> getTransactionHistory(int id) {
        List<Transaction> transactionsDTOS = operationService.getTransactionHistory(id);
        return  new ResponseEntity<List<Transaction>>(transactionsDTOS, HttpStatus.OK);
    }

}