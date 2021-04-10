package com.example.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

    @Modifying
    @Query("update Wallet w set w.balance = w.balance + :amount where w.userId = :userId")
    void updateWallet(String userId, int amount);

    Wallet findByUserId(String userId);

}
