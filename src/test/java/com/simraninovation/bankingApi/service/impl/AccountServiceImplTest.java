package com.simraninovation.bankingApi.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.UserRepository;
import com.simraninovation.bankingApi.service.AccountService;

import java.util.*;

import com.simraninovation.bankingApi.service.CrudService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class AccountServiceImplTest {

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

        Set<Account> accounts = accountService.findAll();

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





}