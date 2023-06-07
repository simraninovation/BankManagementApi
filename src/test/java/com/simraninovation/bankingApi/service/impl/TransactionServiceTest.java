package com.simraninovation.bankingApi.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transaction;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.Transactions;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.TransactionRepository;
import com.simraninovation.bankingApi.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TransactionServiceTest {
	private static Account account ;
    private static User user;
    private static Transactions transaction;
    private AccountServiceImpl accountService;
    private TransactionServiceImp transactionService;

    @Mock
    private AccountRepository accountRepository;
    
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private UserRepository userRepository;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository,userRepository);
        transactionService = new TransactionServiceImp(transactionRepository,accountRepository);
        
    }


    @BeforeAll
    public static void init() {

        user = new User(1L,"test","test","test@test.com","test","12345678");
        account = new Account(2L,"12323223", "Pune","BK01112675","BOI",new Date(),"100",user);
        transaction = new Transactions(3L,"transfered","100","Dr","333",new Date(),account);

    }
    @Test
    void findById() {

    transaction.setId(3L);
    Optional<Transactions> transactionOptional = Optional.of(transaction);
    when(transactionRepository.findById(anyLong())).thenReturn(transactionOptional);

    Transactions transactionReturned = transactionService.findById(2L);

    assertThat(transactionOptional, is(Optional.of(transactionReturned)));
    verify(transactionRepository, times(1)).findById(2L);
    verify(transactionRepository, never()).findAll();

    }
    @Test
    void findByAccountIdTest() {

   	List<Transactions> trans = new ArrayList<>();
	    trans.add(transaction);
	    when(transactionRepository.findByAccountId(Mockito.any())).thenReturn(trans);
	    transactionService.findByAccount_Id(account);
	    verify(transactionRepository, times(1)).findByAccountId(account);
   

   }

}
