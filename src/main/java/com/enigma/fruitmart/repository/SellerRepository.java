package com.enigma.fruitmart.repository;

import com.enigma.fruitmart.entitas.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {
    public Seller findSellerByEmail (String email);

    List<Seller> findSellerBynameSellerContainingIgnoreCase (String sellerName);

//    findCustomerByCustomerNameContainingIgnoreCase
}
