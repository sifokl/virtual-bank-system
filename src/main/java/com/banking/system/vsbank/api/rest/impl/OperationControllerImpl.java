package com.banking.system.vsbank.api.rest.impl;

import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.rest.OperationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationControllerImpl implements OperationController {


    @Override
    public ResponseEntity<List<Transaction>> getTransactionHistory(int id) {

        List<Transaction> transactions = new ArrayList<>();
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
    }
}