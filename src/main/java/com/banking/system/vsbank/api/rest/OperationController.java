package com.banking.system.vsbank.api.rest;

import com.banking.system.vsbank.api.constants.RestConstants;
import com.banking.system.vsbank.api.entity.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OperationController extends MasterInterfaceRest {

    @GetMapping(RestConstants.OPERATION_PATH+"/clients/{id}/history")
    ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable int id);


}
