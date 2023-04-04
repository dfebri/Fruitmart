package com.enigma.simpleproduct.repository;

import com.enigma.simpleproduct.entitas.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    List<Customer> findCustomerByCustomerNameContainingIgnoreCase (String nameCriteria);
}


