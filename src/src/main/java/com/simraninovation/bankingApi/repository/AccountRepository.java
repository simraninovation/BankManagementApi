package com.simraninovation.bankingApi.repository;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    Account findByaccountNumber(String id);

   List<Account> findByUserId(User user);
}
