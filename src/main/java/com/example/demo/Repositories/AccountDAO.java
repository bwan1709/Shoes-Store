package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Account;

public interface AccountDAO extends JpaRepository<Account, Integer> {
    @Query("SELECT a.id, a.username, a.email, SUM(i.tongGia) AS tongChiTieu " +
            "FROM Account a " +
            "INNER JOIN Invoice i ON a.id = i.account.id " +
            "GROUP BY a.id, a.username, a.email " +
            "ORDER BY tongChiTieu DESC")
    List<Object[]> findTop5AccountsByTotalSpending();
    
    Account findByUsernameAndEmail(String username, String email); 
    Account findByEmail(String email); 
    
    Optional<Account> findByUsername(String username);
//    Optional<Account> findByUID(int id);
}
