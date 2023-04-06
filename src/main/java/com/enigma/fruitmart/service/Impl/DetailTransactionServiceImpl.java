package com.enigma.fruitmart.service.Impl;

import com.enigma.fruitmart.entitas.DetailTransaction;
import com.enigma.fruitmart.repository.DetailTransactionRepository;
import com.enigma.fruitmart.service.DetailTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailTransactionServiceImpl implements DetailTransactionService {

    DetailTransactionRepository detailTransactionRepository;

    @Autowired
    public DetailTransactionServiceImpl(DetailTransactionRepository detailTransactionRepository) {
        this.detailTransactionRepository = detailTransactionRepository;
    }

    @Override
    public DetailTransaction saveDetailTranscation(DetailTransaction detailTransaction) {
        return detailTransactionRepository.save(detailTransaction);
    }
}
