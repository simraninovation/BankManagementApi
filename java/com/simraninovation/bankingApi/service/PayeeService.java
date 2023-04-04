package com.simraninovation.bankingApi.service;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.Transactions;

import java.util.List;

public interface PayeeService extends CrudService<PayeeDetails, Long> {


    PayeeDetails findById(Long id);

    List<PayeeDetails> findByAccount_Id(Account account);


}
