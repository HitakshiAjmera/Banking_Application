package com.bankingapp.banking.service;


import com.bankingapp.banking.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    AccountDTO createAccount(AccountDTO accountDto);
    AccountDTO getAccountById(Long id);
    AccountDTO depositAmount(Long id ,double amount);
    AccountDTO withdrawAmount (Long id, double amount);
    List<AccountDTO> getAllAccounts();
    void deleteAccount (Long id);
}
