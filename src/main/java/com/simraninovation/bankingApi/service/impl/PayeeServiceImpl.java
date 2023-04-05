package com.simraninovation.bankingApi.service.impl;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.Transactions;
import com.simraninovation.bankingApi.repository.AccountRepository;
import com.simraninovation.bankingApi.repository.PayeeRepository;
import com.simraninovation.bankingApi.service.PayeeService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;
@Service
public class PayeeServiceImpl implements PayeeService {
    @Autowired
    private PayeeRepository payeeRepository;

    @Autowired
    private final AccountRepository accountRepository;

//    @Autowired
//    private SessionFactory sessionFactory;

    public PayeeServiceImpl(PayeeRepository payeeRepository, AccountRepository accountRepository) {
        this.payeeRepository = payeeRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public Set<PayeeDetails> findAll() {
        return null;
    }

    @Override
    public PayeeDetails save(PayeeDetails object) {
        return payeeRepository.save(object);
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public PayeeDetails findById(Long id) {
        return null;
    }

    @Override
    public List<PayeeDetails> findByAccount_Id(Account account) {
        return payeeRepository.findByAccountId(account);
    }

//    @Override
//    public void updateBalance(Account account) {
//        Query query  = sessionFactory.getCurrentSession().createQuery("update account set balance = :balance where id = :id ");
//        query.setParameter("balance",account.getBalance());
//        query.setParameter("id",account.getId());
//        query.executeUpdate();
//    }



}
