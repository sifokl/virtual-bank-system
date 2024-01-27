package com.banking.system.vsbank.api.rest;

import com.banking.system.vsbank.api.constants.RestConstants;
import com.banking.system.vsbank.api.entity.Transaction;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransactionController extends MasterInterfaceRest {


    @PostMapping(RestConstants.TRANSACTION_PATH+"/accounts/{id}/deposit")
    ResponseEntity<Transaction> performDeposit(@PathVariable int id, @Valid @RequestBody Transaction transactionRequest);

}

