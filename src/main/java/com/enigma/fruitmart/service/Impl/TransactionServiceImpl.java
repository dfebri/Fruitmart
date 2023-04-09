package com.enigma.fruitmart.service.Impl;

import com.enigma.fruitmart.dto.DetailTransactionDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
//            dt.setProductTransactionPrice(product.getProductPrice() * dt.getQuantity());
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
//        if (transactionRepository.findById(id).isPresent()) {
//            Transaction transaction = transactionRepository.findById(id).get();
//            TranscationDTO transcationDTO = new TranscationDTO();
//            transcationDTO.setTransactionid(transaction.getId());
//            transcationDTO.setCustomerName(transaction.getCustomer().getCustomerName());
//            transcationDTO.setTransactionDate(transaction.getDateTransaction());
//            List<DetailTransactionDTO> detailTransactionDTOS = new ArrayList<>();
//
//            Integer total = 0;
//            for (DetailTransaction dt : transaction.getDetailTransactions()) {
//                DetailTransactionDTO detailTransactionDTO = new DetailTransactionDTO();
//                detailTransactionDTO.setNameProduct(dt.getProduct().getNameProduct());
//                detailTransactionDTO.setQuantity(dt.getQuantity());
//                detailTransactionDTO.setPriceSell(dt.getProduct().getProductPrice());
//                Integer subtotal = dt.getProductTransactionPrice() * dt.getQuantity();
//                detailTransactionDTO.setSubTotal(subtotal);
//                total = total + subtotal;
//                detailTransactionDTOS.add(detailTransactionDTO);
//            }
//            transcationDTO.setTotal(total);
//            transcationDTO.setDetailTransactionDTO(detailTransactionDTOS);
//
//            return transcationDTO;
//        }
//        else throw new NoSuchElementException();
//    }
        Transaction transaction = transactionRepository.findById(id).get();
        TranscationDTO transcationDTO = new TranscationDTO();
        transcationDTO.setTransactionid(transaction.getId());
        transcationDTO.setCustomerName(transaction.getCustomer().getCustomerName());
        transcationDTO.setTransactionDate(transaction.getDateTransaction());
        List<DetailTransactionDTO> detailTransactionDTOS = new ArrayList<>();

        Integer total = 0;
        for (DetailTransaction dt : transaction.getDetailTransactions()) {
            DetailTransactionDTO detailTransactionDTO = new DetailTransactionDTO();
            detailTransactionDTO.setNameProduct(dt.getProduct().getNameProduct());
            detailTransactionDTO.setQuantity(dt.getQuantity());
            detailTransactionDTO.setPriceSell(dt.getProductTransactionPrice());
            Integer subtotal = dt.getQuantity() * dt.getProductTransactionPrice();
            detailTransactionDTO.setSubTotal(subtotal);
//            total = total + subtotal;
            total += subtotal;
            detailTransactionDTOS.add(detailTransactionDTO);
        }
        transcationDTO.setTotal(total);
        transcationDTO.setDetailTransactionDTO(detailTransactionDTOS);

        return transcationDTO;
    }
}

