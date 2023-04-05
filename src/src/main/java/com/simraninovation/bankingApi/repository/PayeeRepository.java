package com.simraninovation.bankingApi.repository;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.Transactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayeeRepository extends CrudRepository<PayeeDetails, Long> {

    PayeeDetails findByaccountId(Long id);

    List<PayeeDetails> findByAccountId(Account account);
}
