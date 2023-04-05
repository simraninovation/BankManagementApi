package com.simraninovation.bankingApi.service;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.Transactions;

import java.util.List;

public interface TransactionService extends CrudService<Transactions, Long>{

        Transactions findById(Long id);

        List<Transactions> findByAccount_Id(Account account);

}
