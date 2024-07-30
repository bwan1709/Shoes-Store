package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cart;

import jakarta.transaction.Transactional;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
	Optional<Cart> findByProductId(int productID);
    void deleteByProductId(int productID);
    Optional<Cart> findByProductIdAndSize(int productId, String size);
	Optional<Cart> findByProductIdAndSizeAndAccountId(int productId,String size,int accountId);
    List<Cart> findByAccountId(int uID); 
    List<Cart> findByAccountIsNull();
    Optional<Cart> findByProductIdAndSizeAndAccountIsNull(int productId, String size);
    void deleteByAccountId(int accountId);
    @Transactional
    @Modifying
    @Query("DELETE FROM Cart c WHERE c.account.id = :accountID OR c.account.id IS NULL")
    void deleteByAccountIdOrAccountIdIsNull(@Param("accountID") Integer accountId);
}
