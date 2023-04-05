package com.enigma.simpleproduct.repository;

import com.enigma.simpleproduct.entitas.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, String> {
    public Seller findSellerByEmail (String email);

    List<Seller> findSellerBynameSellerContainingIgnoreCase (String sellerName);
//    findCustomerByCustomerNameContainingIgnoreCase
}
