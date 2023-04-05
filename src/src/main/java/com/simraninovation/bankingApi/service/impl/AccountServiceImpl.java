package com.simraninovation.bankingApi.service.impl;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.UserRepository;
import com.simraninovation.bankingApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<Account> findAll() {
        Set<Account> accountDetails= new HashSet<>();
        accountRepository.findAll().forEach(accountDetails::add);
        return accountDetails;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account findByaccountNumber(String acct_id) {
        return accountRepository.findByaccountNumber(acct_id);
    }

    @Override
    public Account save(Account object) {
        System.out.println("object"+ object);
        return accountRepository.save(object);
    }

    @Override
    public void delete() {
        accountRepository.deleteAll();
    }

    @Override
    public void deleteById(Long idToDelete) {
        accountRepository.deleteById(idToDelete);
    }

    @Override
    public List<Account> finByUser_Id(User user) {
        return accountRepository.findByUserId(user);
    }


    @Override
    public void updateAccountBalance(Account accountDetails){
        Account account = accountRepository.findById(accountDetails.getId()).orElse(null);;
        account.setBalance((accountDetails.getBalance()));
        accountRepository.save(account);
    }



}
