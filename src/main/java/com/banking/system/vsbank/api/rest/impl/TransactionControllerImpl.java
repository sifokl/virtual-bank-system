package com.banking.system.vsbank.api.rest.impl;


import com.banking.system.vsbank.api.entity.Transaction;
import com.banking.system.vsbank.api.rest.TransactionController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionControllerImpl implements TransactionController {

   // @Autowired
   // TransactionService transactionService;

    @Override
    public ResponseEntity<Transaction> performDeposit(int id, Transaction transactionRequest) {
     //   Transaction depositTransaction = transactionService.performDeposit(id, transactionRequest);
      //  return  new ResponseEntity<Transaction>(depositTransaction, HttpStatus.CREATED);
        return null;
    }


}
