package com.simraninovation.bankingApi.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import java.util.*;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.UserRepository;
import com.simraninovation.bankingApi.service.impl.AccountServiceImpl;

import org.junit.jupiter.api.*;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class AccountServiceTest {

    private static Account account ;
    private static User user;
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserRepository userRepository;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository,userRepository);
    }


    @BeforeAll
    public static void init() {

        user = new User(1L,"test","test","test@test.com","test","12345678");
        account = new Account(2L,"12323223", "Pune","BK01112675","BOI",new Date(),"100",user);

    }




    @Test
    void findAll() {

        HashSet accountData = new HashSet();
        accountData.add(account);

        when(accountService.findAll()).thenReturn(accountData);

        java.util.Set<Account> accounts = accountService.findAll();

        assertEquals(accounts.size(), 1);
        verify(accountRepository, times(1)).findAll();
        verify(accountRepository, never()).findById(anyLong());
    }

    @Test
    void findById() {
//    Account account = new Account();
    account.setId(2L);
    Optional<Account> accountOptional = Optional.of(account);
    when(accountRepository.findById(anyLong())).thenReturn(accountOptional);

    Account accountReturned = accountService.findById(1L);

    assertThat(accountOptional, is(Optional.of(accountReturned)));
    verify(accountRepository, times(1)).findById(1L);
    verify(accountRepository, never()).findAll();

    }

    @Test
    void findByaccountNumber() {

        account.setAccountNumber("12323223");
        Account accountData = account;
        when(accountRepository.findByaccountNumber(anyString())).thenReturn(accountData);

        Account accountReturned = accountService.findByaccountNumber("12323223");

        assertThat(accountData, is(accountReturned));
        verify(accountRepository, times(1)).findByaccountNumber("12323223");
        verify(accountRepository, never()).findAll();
    }
    @Test
    public void testUpdateAccountBalance() {
       
        Account accountDetails = new Account();
        accountDetails.setId(1L);
        accountDetails.setBalance("1000");
        
        Account existingAccount = new Account();
        existingAccount.setId(1L);
        existingAccount.setBalance("500");
        
      
        Mockito.when(accountRepository.findById(1L)).thenReturn(Optional.of(existingAccount));
        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(existingAccount);
        
        
       String result =  accountService.updateAccountBalance(accountDetails);
        
       
        Assertions.assertEquals(accountDetails.getBalance(), existingAccount.getBalance());
        Assertions.assertEquals("Successfully updated", result);
        
       
        Mockito.verify(accountRepository, Mockito.times(1)).save(existingAccount);
    }




}
