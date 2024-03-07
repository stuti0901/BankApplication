package com.project.bankingApp.mapper;

import com.project.bankingApp.dto.AccountDto;
import com.project.bankingApp.entity.Account;

public class AccountMapper {

    public static Account  mapToAccount(AccountDto accountDto)
    {
        Account account=new Account(
             accountDto.getAccountNumber(),
             accountDto.getName(),
             accountDto.getBalance()

        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getAccountNumber(),
                account.getName(),
                account.getBalance()
        );

        return accountDto;
    }

}
