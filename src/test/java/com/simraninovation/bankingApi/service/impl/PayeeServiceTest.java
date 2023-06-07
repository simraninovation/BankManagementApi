//package com.simraninovation.bankingApi.service.impl;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.simraninovation.bankingApi.model.Account;
//import com.simraninovation.bankingApi.model.PayeeDetails;
//import com.simraninovation.bankingApi.model.User;
//import com.simraninovation.bankingApi.repository.AccountRepository;
//import com.simraninovation.bankingApi.repository.PayeeRepository;
//
//
//@ExtendWith(MockitoExtension.class)
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
//public class PayeeServiceTest {
//	 private static PayeeDetails payee ;
//	 private static Account account;
//	 private static User user;
//	   
//	   
//	    private PayeeServiceImpl payeeService;
//
//	    @Mock
//	    private PayeeRepository payeeRepository;
//
//	    @Mock
//	    private AccountRepository accountRepository;
//	    @BeforeEach
//	    public void setup(){
//	        MockitoAnnotations.initMocks(this);
//	        payeeService = new PayeeServiceImpl(payeeRepository,accountRepository);
//	    }
//	    @BeforeAll
//	    public static void init() {
//	    	 user = new User(1L,"test","test","test@test.com","test","12345678");
//
//	    	 account = new Account(2L,"12323223", "Pune","BK01112675","BOI",new Date(),"100",user);
//	    	 payee = new PayeeDetails(3L,"333","BK01112675","ravi",new Date(),account);
//
//
//	    }
//      
//	    
////	    @Test
////	    public void testFindByAccount_Id() {
////	    	List<PayeeDetails> pay = new ArrayList<>();
////	    	PayeeDetails payeeDetails = new PayeeDetails();
////	    	//payeeDetails.setAccountId(2L);
////	    	Mockito.when(payeeRepository.findByAccountId(Mockito.any())).thenReturn(pay);
////	    	payeeService.findByAccount_Id(Mockito.any());
////	    	//assertThat(accountData, is(accountReturned));
////	        verify(payeeService, times(1)).findByAccount_Id(Mockito.any());
////	       // verify(accountRepository, never()).findAll();
////	    }
//	    @Test
//	    public void findById() {
////	    Account account = new Account();
//	    	List<PayeeDetails> pay = new ArrayList<>();
//	    	pay.add(payee);
//	    	when(accountRepository.findById(anyLong())).thenReturn(Mockito.any());
//	    
//	       
//	    when(payeeRepository.findByAccountId(Mockito.any())).thenReturn(pay);
//	    payeeService.findByAccount_Id(account);
//
//	   // Account accountReturned = accountService.findById(1L);
//
//	   // assertThat(accountOptional, is(Optional.of(accountReturned)));
//	    verify(payeeRepository, times(1)).findByAccountId(account);
//	    //verify(payeeRepository, never()).findAll();
//
//	    }
//
//
//}
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
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import java.util.*;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.PayeeRepository;
import com.simraninovation.bankingApi.repository.UserRepository;
import com.simraninovation.bankingApi.service.impl.AccountServiceImpl;

import org.junit.jupiter.api.*;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class PayeeServiceTest {

    private static Account account ;
    private static User user;
    private static PayeeDetails payee;
    private AccountServiceImpl accountService;
    private PayeeServiceImpl payeeService;
    

    @Mock
    private AccountRepository accountRepository;
    @Mock
     private PayeeRepository payeeRepository;

    @Mock
    private UserRepository userRepository;
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountRepository,userRepository);
        payeeService = new PayeeServiceImpl(payeeRepository,accountRepository);
    }


    @BeforeAll
    public static void init() {
    	 user = new User(1L,"test","test","test@test.com","test","12345678");

    	 account = new Account(2L,"12323223", "Pune","BK01112675","BOI",new Date(),"100",user);
    	 payee = new PayeeDetails(3L,"333","BK01112675","ravi",new Date(),account);


    }




 
    
    
    
    @Test
     void findByAccountIdTest() {

    	List<PayeeDetails> pay = new ArrayList<>();
	    pay.add(payee);
	    when(payeeRepository.findByAccountId(Mockito.any())).thenReturn(pay);
	    payeeService.findByAccount_Id(account);
	    verify(payeeRepository, times(1)).findByAccountId(account);
    

    }
    @Test
    public void testUpdatepayee() {
       
        PayeeDetails payeeDetails = new PayeeDetails();
        payeeDetails.setAccountNumber("4567");
        payeeDetails.setIfsc("SIB-12345");
        
        PayeeDetails existingPayee = new PayeeDetails();
        existingPayee.setAccountNumber("4567");;
        existingPayee.setIfsc("BIB-1234");
        
      
       
        Mockito.doNothing().when(payeeRepository).updatepayeeDetails(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any());
        
        
       
        payeeService.updatepayeeDetails(payeeDetails);
        
       Mockito.verify(payeeRepository, Mockito.times(1)).updatepayeeDetails(Mockito.any(),Mockito.any(),Mockito.any(),Mockito.any());
        
    }





}

