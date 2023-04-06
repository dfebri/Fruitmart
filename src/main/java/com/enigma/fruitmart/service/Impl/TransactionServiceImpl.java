package com.enigma.fruitmart.service.Impl;

import com.enigma.fruitmart.dto.TranscationDTO;
import com.enigma.fruitmart.entitas.Customer;
import com.enigma.fruitmart.entitas.DetailTransaction;
import com.enigma.fruitmart.entitas.Product;
import com.enigma.fruitmart.entitas.Transaction;
import com.enigma.fruitmart.repository.TransactionRepository;
import com.enigma.fruitmart.service.CustomerService;
import com.enigma.fruitmart.service.DetailTransactionService;
import com.enigma.fruitmart.service.ProductService;
import com.enigma.fruitmart.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    DetailTransactionService detailTransactionService;

    CustomerService customerService;

    ProductService productService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, DetailTransactionService detailTransactionService, CustomerService customerService, ProductService productService) {
        this.transactionRepository = transactionRepository;
        this.detailTransactionService = detailTransactionService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    @Transactional
    public Transaction saveTransaction(Transaction transaction) {
//        transaction.setDateTransaction(Date.valueOf(LocalDate.now()));
        Transaction saveTransactions = transactionRepository.save(transaction);
        Customer customer = customerService.getCustomerById(saveTransactions.getCustomer().getId());
        saveTransactions.setCustomer(customer);

        for (DetailTransaction dt : transaction.getDetailTransactions()) {
            Product product = productService.getProductById(dt.getProduct().getId());
            product.setStock(product.getStock() - dt.getQuantity());
            dt.setProduct(product);
            dt.setTransaction(saveTransactions);
            detailTransactionService.saveDetailTranscation(dt);
        }

        return saveTransactions;
    }

    @Override
    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public TranscationDTO getTransactionDTOById(String id) {
        return null;
    }
}
