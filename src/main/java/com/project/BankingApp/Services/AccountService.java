package com.project.BankingApp.Services;

import com.project.BankingApp.Models.Account;
import com.project.BankingApp.Repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account createaccount(Account account)
    {
        return accountRepo.save(account);
    }

    public Optional<Account> getaccount(Long id)
    {
        return accountRepo.findById(id);
    }

    public Account deposit(Long id, double amount)
    {
        Account account = getaccount(id).orElseThrow(() -> new RuntimeException("Account doesn't exist!!!"));
        account.setBalance(account.getBalance() + amount);
        return accountRepo.save(account);
    }

    public Account withdraw(Long id, double amount)
    {
        Account account = getaccount(id).orElseThrow(() -> new RuntimeException("Account does not exist!!!"));
        if(account.getBalance() < amount)
        {
            throw new RuntimeException("Insufficient funds!");
        }
        else
        {
            account.setBalance(account.getBalance()-amount);
        }
        return accountRepo.save(account);
    }

}
