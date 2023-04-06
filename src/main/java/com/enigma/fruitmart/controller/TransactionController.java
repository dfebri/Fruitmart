package com.enigma.fruitmart.controller;

import com.enigma.fruitmart.entitas.DetailTransaction;
import com.enigma.fruitmart.entitas.Transaction;
import com.enigma.fruitmart.service.DetailTransactionService;
import com.enigma.fruitmart.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "transactions")
public class TransactionController {

    TransactionService transactionService;

    DetailTransactionService detailTransactionService;

    @Autowired
    public TransactionController(TransactionService transactionService, DetailTransactionService detailTransactionService) {
        this.transactionService = transactionService;
        this.detailTransactionService = detailTransactionService;
    }

    @PostMapping(value = "transactions")
    public Transaction saveTranscation (@RequestBody Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    @PostMapping(value = "/transactions-detail")
    public DetailTransaction saveDetailTransaction (@RequestBody DetailTransaction detailTransaction){
        return detailTransactionService.saveDetailTranscation(detailTransaction);
    }
}
