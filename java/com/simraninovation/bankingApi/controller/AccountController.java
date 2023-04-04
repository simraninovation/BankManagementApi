package com.simraninovation.bankingApi.controller;

import com.simraninovation.bankingApi.model.Account;
import com.simraninovation.bankingApi.model.User;
import com.simraninovation.bankingApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    private final AccountService accountService;



    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account/new")
    public String saveDetails(@RequestBody Account account) {
        System.out.println(account);
        Account save = accountService.save(account);
        return "Successfully Added " ;
    }
    @GetMapping("/account/acctNum/{acctNumber}")
    @ResponseBody
    public Account getAccountNumber(@PathVariable("acctNumber") String acct_id) {
        return accountService.findByaccountNumber(acct_id);

    }
    @GetMapping("/account/{id}")
    @ResponseBody
    public Account getAccountId(@PathVariable("id") Long acct_id) {
        return accountService.findById(acct_id);

    }

    @GetMapping("/accounts")
    public @ResponseBody
    Set<Account> getAccounts()  {
        return accountService.findAll();


    }

    @GetMapping("/account/user/{userId}")
    @ResponseBody
    public List<Account> getUserAccount(@PathVariable("userId") User user) {

        return accountService.finByUser_Id(user);

    }

    @RequestMapping(value="account/update", method = RequestMethod.POST)
    public void updateAccountBalance( @RequestBody Account account){
        accountService.updateAccountBalance(account);
    }


}
