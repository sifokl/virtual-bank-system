package com.banking.system.vsbank.api.entity;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    private int idAccount;
    private int idOwner;
    private long balance;
}
