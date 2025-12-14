package com.bankingapp.banking.controller;

import com.bankingapp.banking.dto.AccountDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bankingapp.banking.service.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    //denpendency injection
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account RESTAPI
    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    //basic getapi
    @GetMapping("/abc/{id}")
    public String str(@PathVariable("id")int id){
        return "str " + id;
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id)
    {
        AccountDTO accountDTO = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> depositAmount(@PathVariable Long id,
                                                     @RequestBody Map<String,Double> request)
    {
        AccountDTO accountDTO = accountService.depositAmount(id,request.get("amount"));
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/{id}/withdraw")
            public ResponseEntity<AccountDTO> withdrawAmount (@PathVariable Long id,
                                                              @RequestBody Map<String,Double> request)
    {
        return ResponseEntity.ok(accountService.withdrawAmount(id,request.get("amount")));
    }

    //Get all account restapi
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts()
    {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //delete account rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
