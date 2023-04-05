package com.simraninovation.bankingApi.service.impl;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.Transactions;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.TransactionRepository;
import com.simraninovation.bankingApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TransactionServiceImp implements TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;
    @Autowired
    private final AccountRepository accountRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Set<Transactions> findAll() {
        return null;
    }

    @Override
    public Transactions save(Transactions object) {
        return transactionRepository.save(object);
    }

    @Override
    public Transactions findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }



    @Override
    public List<Transactions> findByAccount_Id(Account account) {
        return transactionRepository.findByAccountId(account);
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
