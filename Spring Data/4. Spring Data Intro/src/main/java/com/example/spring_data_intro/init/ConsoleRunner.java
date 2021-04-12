package com.example.spring_data_intro.init;

import com.example.spring_data_intro.entities.Account;
import com.example.spring_data_intro.entities.User;
import com.example.spring_data_intro.services.AccountService;
import com.example.spring_data_intro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Ivan Petrov",42);
        Account account1 = new Account(new BigDecimal(1500));

        user1 = userService.register(user1);
        account1 = accountService.createUserAccount(user1, account1);

        accountService.withdrawMoney(new BigDecimal(1000),account1.getId());
        accountService.depositMoney(new BigDecimal(200),account1.getId());
        accountService.getAllAccounts().forEach(System.out::println);

        User user2 = new User("Ivan Petrov",25);
        Account account2 = new Account(new BigDecimal(23000));

        user2 = userService.register(user2);
        account2 = accountService.createUserAccount(user2, account2);


        accountService.transferMoney(new BigDecimal(1000),account1.getId(),account2.getId());
        accountService.getAllAccounts().forEach(System.out::println);

    }
}
