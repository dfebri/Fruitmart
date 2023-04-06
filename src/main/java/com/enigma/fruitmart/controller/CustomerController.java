package com.enigma.fruitmart.controller;

import com.enigma.fruitmart.entitas.Customer;
import com.enigma.fruitmart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer saveCustomer (@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping
    public Customer updateCustomer (@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/list")
    public List<Customer> getAllCustomer (){
        return customerService.getAllCustomer();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById (@PathVariable String id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer (@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @GetMapping("/searchname")
    public List<Customer> searchCustomer(@RequestParam(name = "customerName") String customerName){
        return customerService.searchCustomer(customerName);
    }





}
