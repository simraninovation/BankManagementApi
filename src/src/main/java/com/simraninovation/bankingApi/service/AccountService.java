package com.simraninovation.bankingApi.service;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;

import java.util.List;

public interface AccountService extends CrudService<Account,Long> {

    Account findById(Long l);

    Account findByaccountNumber (String acct_id);

    void deleteById(Long idToDelete);

    List<Account> finByUser_Id(User user);

    void updateAccountBalance(Account account);

}

