package com.banking.system.vsbank.api.repository;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TRepository<T> {

    T findById(int id);
    List<T> findAll();
    boolean save(T t);
    List<T> saveAll(List<T> list);

    boolean update(T t);

    boolean deleteAll();
}
