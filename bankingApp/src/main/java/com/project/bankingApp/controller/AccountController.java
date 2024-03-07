package com.project.bankingApp.controller;

import com.project.bankingApp.dto.AccountDto;
import com.project.bankingApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto>  addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{accountNumber}")
    public  ResponseEntity<AccountDto> getAccountById(@PathVariable  Long accountNumber)
    {
        AccountDto accountDto=accountService.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable  Long accountNumber, @RequestBody  Map<String,Double> request)
    {
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(accountNumber,amount);
        return  ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,   @RequestBody Map<String,Double> request)
    {
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
   @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
        List<AccountDto> accounts=accountService.getAllAccounts();
        return  ResponseEntity.ok(accounts);
    }




}
