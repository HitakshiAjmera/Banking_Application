package com.bankingapp.banking.service;

import com.bankingapp.banking.dto.AccountDTO;
import com.bankingapp.banking.mapper.AccountMapper;
import com.bankingapp.banking.repository.AccountRepository;
import org.hibernate.property.access.internal.PropertyAccessCompositeUserTypeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bankingapp.banking.entity.Account;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    //dependency injection of account repository
    private AccountRepository accountRepository;

    //constructor based dendency injection
    // @Autowired //it not require as it has single constructor
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDto) {

        Account account = AccountMapper.maptoAccount(accountDto);
            Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDTO(account);
    }

    @Override
    public AccountDTO depositAmount(Long id ,double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Account does not exist"));
        double balance =account.getBalance() + amount;
        account.setBalance(balance);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO withdrawAmount(Long id, double amount) {

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        if (amount > account.getBalance()) {
            throw new RuntimeException("Insufficient amount");
        }
        double totalAmount = account.getBalance() - amount;
        account.setBalance(totalAmount);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map((account) -> AccountMapper.mapToAccountDTO(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);
        // hello
    }
}
