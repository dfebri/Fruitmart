package com.enigma.fruitmart.service.Impl;

import com.enigma.fruitmart.entitas.Customer;
import com.enigma.fruitmart.repository.CustomerRepository;
import com.enigma.fruitmart.service.CustomerService;
import com.enigma.fruitmart.utils.exeption.DataNotFoundException;
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
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customerRepository.findById(customer.getId()).isPresent()){
            return saveCustomer(customer);
        }else {
            throw new DataNotFoundException("Id Customer" + customer.getId() + "Not Found");
        }

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> searchCustomer(String customerName) {
        return customerRepository.findCustomerByCustomerNameContainingIgnoreCase(customerName);
    }
}
