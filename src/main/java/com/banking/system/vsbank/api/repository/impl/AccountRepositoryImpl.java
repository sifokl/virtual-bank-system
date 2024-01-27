package com.banking.system.vsbank.api.repository.impl;

import com.banking.system.vsbank.api.entity.Account;
import com.banking.system.vsbank.api.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private List<Account> accounts;

    @PostConstruct
    private void populateRepository(){
        accounts = new ArrayList<>();
        //two accounts for user 1
        Account account1 = Account.builder().idAccount(1).idOwner(1).balance(0).build();
        Account account2 = Account.builder().idAccount(2).idOwner(1).balance(0).build();
        accounts.add(account1);
        accounts.add(account2);
    }
    @Override
    public Account findById(int id) {
        Account accountById =  accounts.stream().flatMap(s -> Stream.ofNullable(s)).filter(acc->acc.getIdAccount()==id).findAny()
                .orElse(null);
        return accountById;
    }

    @Override
    public List<Account> findAll() {
        return accounts;
    }

    @Override
    public boolean save(Account account) {
        return accounts.add(account);
    }

    @Override
    public List<Account> saveAll(List<Account> list) {
        list.forEach(acc->accounts.add(acc));
        return accounts;
    }

    @Override
    public boolean update(Account account) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        accounts.clear();
        return true;
    }
}
