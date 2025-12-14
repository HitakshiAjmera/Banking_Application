package com.bankingapp.banking.mapper;

import com.bankingapp.banking.dto.AccountDTO;
import com.bankingapp.banking.entity.Account;

public class AccountMapper {

    public static Account maptoAccount(AccountDTO accountDTO)
    {
        Account account  = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getBalance()
        );
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account){

        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance());
        return accountDTO;

    }


}
