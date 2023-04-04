package com.simraninovation.bankingApi.service.impl;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.repository.UserRepository;
import com.simraninovation.bankingApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Set<User> findAll() {
        Set<User>  userDetails= new HashSet<>();
        userRepository.findAll().forEach(userDetails::add);
        return userDetails;
    }

    @Override
    public User save(User object) {
        System.out.println("Test "+ object);
        return userRepository.save(object);
    }

    @Override
    public void delete() {
    userRepository.deleteAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long idToDelete) {
        userRepository.deleteById(idToDelete);
    }



    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
