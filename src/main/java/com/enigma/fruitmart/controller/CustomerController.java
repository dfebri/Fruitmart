package com.enigma.fruitmart.controller;

import com.enigma.fruitmart.entitas.Customer;
import com.enigma.fruitmart.service.CustomerService;
import com.enigma.fruitmart.utils.customRespone.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response<Customer>> saveCustomer (@RequestBody Customer customer){
        String message = "Data customer has been inserted";
        Response<Customer> response = new Response<>();
        response.setMessage(message);
        response.setData(customerService.saveCustomer(customer));
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
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
