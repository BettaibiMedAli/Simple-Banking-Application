package com.project.BankingApp.Repositories;

import com.project.BankingApp.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
