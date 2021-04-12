package com.example.spring_data_intro.services.impl;

import com.example.spring_data_intro.entities.Account;
import com.example.spring_data_intro.entities.User;
import com.example.spring_data_intro.exception.InvalidAccountOperation;
import com.example.spring_data_intro.exception.NonexistingEntityException;
import com.example.spring_data_intro.repositories.AccountRepository;
import com.example.spring_data_intro.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepo;

    @Autowired
    public void setAccountRepo(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public Account createUserAccount(User user, Account account) {
        account.setId(null);
        account.setUser(user);
        user.getAccounts().add(account);
        return accountRepo.save(account);
    }

    @Override
    public void withdrawMoney(BigDecimal amount, Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(() ->
                new NonexistingEntityException(
                        String.format("Entity with ID:%s does not exist.", accountId)));
        if (account.getBalance().compareTo(amount) < 0) {
            throw new InvalidAccountOperation(
                    String.format("Account ID:%s balance (%s) is less than required withdraw amount: %s",
                            accountId,account.getBalance(),amount));
        }
        account.setBalance(account.getBalance().subtract(amount));
    }

    @Override
    public void depositMoney(BigDecimal amount, Long accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(() ->
                new NonexistingEntityException(
                        String.format("Entity with ID:%s does not exist.", accountId)));

        account.setBalance(account.getBalance().add(amount));
    }

    @Override
    public void transferMoney(BigDecimal amount, Long fromId, Long toId) {
        depositMoney(amount,toId);
        withdrawMoney(amount,fromId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
}
