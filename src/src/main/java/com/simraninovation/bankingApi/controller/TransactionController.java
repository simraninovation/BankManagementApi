package com.simraninovation.bankingApi.controller;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.Transactions;
import com.simraninovation.bankingApi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("transactions/new")
    public String saveTransaction(@RequestBody Transactions transactions){
        Transactions transaction = transactionService.save(transactions);
        return "Transaction Saved!";
    }

    @RequestMapping(value="transaction/{accountId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Transactions> getUserTransaction(@PathVariable("accountId") Account account){
       System.out.println(account);

        return transactionService.findByAccount_Id(account);

    }
}
