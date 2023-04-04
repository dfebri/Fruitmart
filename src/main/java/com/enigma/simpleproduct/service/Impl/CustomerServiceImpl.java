package com.enigma.simpleproduct.service.Impl;

import com.enigma.simpleproduct.entitas.Customer;
import com.enigma.simpleproduct.repository.CustomerRepository;
import com.enigma.simpleproduct.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    public Customer getCustomerById(String id) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public List<Customer> searchCustomer(String customerName) {
        return null;
    }
}
