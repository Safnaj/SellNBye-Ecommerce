package com.paf.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
