package com.project.bankingApp.service;

import com.project.bankingApp.dto.AccountDto;
import com.project.bankingApp.entity.Account;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto account);
    AccountDto getAccountByNumber(long accountNumber);
    AccountDto deposit(Long accountNumber,double amount);
    AccountDto withdraw(Long accountNumber,double amount);
   List<AccountDto> getAllAccounts();


}
