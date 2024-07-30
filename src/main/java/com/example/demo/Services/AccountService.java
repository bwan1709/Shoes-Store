package com.example.demo.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Account;
import com.example.demo.Repositories.AccountDAO;

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }
    
    public List<Object[]> getTop5AccountsByTotalSpending() {
        return accountDAO.findTop5AccountsByTotalSpending();
    }

    public void updateAccount(Account account) {
        accountDAO.save(account);
    }

    public Account findAccountById(int id) {
        return accountDAO.findById(id).orElse(null);
    }

    

    public Account findByUsernameAndEmail(String username, String email) {
        return accountDAO.findByUsernameAndEmail(username, email);
    }

    public Account findByEmail(String email) {
        return accountDAO.findByEmail(email);
    }
}
