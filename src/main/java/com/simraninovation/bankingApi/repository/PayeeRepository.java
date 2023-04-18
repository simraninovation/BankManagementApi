package com.simraninovation.bankingApi.repository;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.Transactions;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PayeeRepository extends CrudRepository<PayeeDetails, Long> {

    PayeeDetails findByaccountId(Long id);

    List<PayeeDetails> findByAccountId(Account account);
    
    void deleteById(Long accountId);
    
    @Transactional
    @Modifying
    @Query("update PayeeDetails  set accountNumber=:accountNumber , ifsc =:ifsc , name =:name where id=:id")
   void updatepayeeDetails(@Param("accountNumber") String accountNumber, @Param("id") Long id,@Param ("ifsc") String ifsc, @Param("name") String name);
    
   
}
