package com.simraninovation.bankingApi.controller;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.PayeeDetails;
import com.simraninovation.bankingApi.model.Transactions;
import com.simraninovation.bankingApi.service.PayeeService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PayeeController {

    @Autowired
    private PayeeService payeeService;

    @PostMapping("payee/create")
    public String saveTransaction(@RequestBody PayeeDetails payeeDetails){
        payeeService.save(payeeDetails);
        return "Transaction Saved!";
    }

    @RequestMapping(value="payee/account/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public List<PayeeDetails> gePayeeInfo(@PathVariable("accountId") Account account){
        System.out.println(account);

        return payeeService.findByAccount_Id(account);

    }
    
    
    ///Delete function
    @DeleteMapping("payee/delete/{accountId}")
    public int deletePayee(@PathVariable("accountId") Long accountId){
    	
       
        payeeService.deleteById(accountId);
        return 1;
        
   
    }
    

    @PutMapping("payee/update")
    public String updatepayeeDetails(@RequestBody PayeeDetails payeeDetails){
        payeeService.updatepayeeDetails(payeeDetails);
        return "payee saved!";
    }
    
    



}
