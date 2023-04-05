package com.simraninovation.bankingApi.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.simraninovation.bankingApi.service.UserService;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserServiceTest {
	
	    private static User user;
	    private UserServiceImp userService;
	    @Mock
	    private UserRepository userRepository;
	    @BeforeEach
	    public void setup(){
	        MockitoAnnotations.initMocks(this);
	        userService = new UserServiceImp(userRepository);
	    }
	    @BeforeAll
	    public static void init() {

	        user = new User(1L,"test","test","test@test.com","test","12345678");

	    }
	    @Test
	    void findAll() {

	        HashSet userData = new HashSet();
	        userData.add(user);

	        when(userService.findAll()).thenReturn(userData);

	        java.util.Set<User> user = userService.findAll();

	        assertEquals(user.size(), 1);
	        verify(userRepository, times(1)).findAll();
	        verify(userRepository, never()).findById(anyLong());
	    }

	    @Test
	    void findById() {
//	    Account account = new Account();
	    user.setId(1L);
	    Optional<User> userOptional = Optional.of(user);
	    when(userRepository.findById(anyLong())).thenReturn(userOptional);

	    User userReturned = userService.findById(1L);

	    assertThat(userOptional, is(Optional.of(userReturned)));
	    verify(userRepository, times(1)).findById(1L);
	    verify(userRepository, never()).findAll();

	    }
}
