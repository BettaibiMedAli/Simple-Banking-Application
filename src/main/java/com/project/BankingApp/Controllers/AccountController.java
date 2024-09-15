package com.project.BankingApp.Controllers;

import com.project.BankingApp.Models.Account;
import com.project.BankingApp.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getaccount(@PathVariable Long id)
    {
        return accountService.getaccount(id).orElseThrow(()-> new RuntimeException("Account does not exist!!!"));
    }

    @PostMapping
    public Account createaccount(@RequestBody Account account)
    {
        return accountService.createaccount(account);
    }

    @PostMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request)
    {
        Double amount = request.get("amount");
        return accountService.deposit(id, amount);
    }

    @PostMapping("/{id}/withdraw")
    public Account withdraw (@PathVariable Long id, @RequestBody Map<String, Double> request)
    {
        Double amount = request.get("amount");
        return accountService.withdraw(id, amount);
    }
}
