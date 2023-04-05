package com.simraninovation.bankingApi.service;

import com.simraninovation.bankingApi.model.User;

import java.util.Set;

public interface UserService extends CrudService<User, Long>{
    User findById(Long l);

    void deleteById(Long idToDelete);

    User findByEmail(String email);


}
