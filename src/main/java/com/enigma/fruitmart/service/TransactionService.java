package com.enigma.fruitmart.service;

import com.enigma.fruitmart.dto.TranscationDTO;
import com.enigma.fruitmart.entitas.Transaction;

public interface TransactionService {
    Transaction saveTransaction (Transaction transaction);
    Transaction getTransactionById (String id);
    TranscationDTO getTransactionDTOById (String id);

}
