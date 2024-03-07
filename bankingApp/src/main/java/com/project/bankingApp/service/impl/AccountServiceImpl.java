package com.project.bankingApp.service.impl;

import com.project.bankingApp.dto.AccountDto;
import com.project.bankingApp.entity.Account;
import com.project.bankingApp.mapper.AccountMapper;
import com.project.bankingApp.repository.AccountRepository;
import com.project.bankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=AccountMapper.mapToAccount((accountDto));
        Account savedAccount = accountRepository.save(account);
        System.out.println(savedAccount);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountByNumber(long accountNumber) {
        Account account =accountRepository
                .findById(accountNumber)
                .orElseThrow(()->new RuntimeException("Account does not exist"));

        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long accountNumber, double amount) {
        Account account =accountRepository
                .findById(accountNumber)
                .orElseThrow(()->new RuntimeException("Account does not exist"));


       double total= account.getBalance()+amount;
       account.setBalance(total);
       Account savedAccount =accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long accountNumber, double amount) {
        Account account =accountRepository
                .findById(accountNumber)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        if(account.getBalance()<amount)
        {
            throw  new RuntimeException("Insufficient amount");
        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);





        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts= accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }
}
