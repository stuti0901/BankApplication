package com.project.bankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private long accountNumber;
    private String name;
    private double balance;
}
