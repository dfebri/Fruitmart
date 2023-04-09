package com.enigma.fruitmart.repository;

import com.enigma.fruitmart.entitas.DetailTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailTransactionRepository extends JpaRepository<DetailTransaction, String> {
}
