package com.enigma.fruitmart.repository;

import com.enigma.fruitmart.entitas.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
