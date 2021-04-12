package com.example.spring_data_intro.services;

import com.example.spring_data_intro.entities.Account;
import com.example.spring_data_intro.entities.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface AccountService {
    Account createUserAccount(User user, Account account);
    void withdrawMoney(BigDecimal amount, Long accountId);
    void depositMoney(BigDecimal amount, Long accountId);
    void transferMoney(BigDecimal amount, Long fromId, Long toId);
    List<Account> getAllAccounts();
}
