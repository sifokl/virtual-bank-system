package com.banking.system.vsbank.api.entity;

import com.banking.system.vsbank.api.constants.TransactionType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    private long idTransaction;
    private int idTransactionAccount;
    private int idTransactionClient;
    private long postTransactionGlobalBalance;
    @NotBlank(message = "transaction amount is mandatory for each transaction ")
    private long transactionAmount;
    private Date transactionDate;
    private TransactionType type;
}
