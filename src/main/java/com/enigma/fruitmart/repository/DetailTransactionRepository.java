package com.enigma.fruitmart.repository;

import com.enigma.fruitmart.entitas.DetailTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailTransactionRepository extends JpaRepository<DetailTransaction, String> {

//    @Query
//    public List<DetailTransaction> GetDetailTransactionWithMaxPrice (Integer maxPrice);
}
