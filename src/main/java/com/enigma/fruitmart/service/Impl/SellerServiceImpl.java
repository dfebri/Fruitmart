package com.enigma.fruitmart.service.Impl;

import com.enigma.fruitmart.entitas.Seller;
import com.enigma.fruitmart.repository.SellerRepository;
import com.enigma.fruitmart.service.SellerService;
import com.enigma.fruitmart.utils.exeption.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller updateSeller(Seller seller) {
        if (sellerRepository.findById(seller.getId()).isPresent()) {
            return saveSeller(seller);
        }else {
            throw new DataNotFoundException("id seller" + seller.getId() + "is not found");

        }
    }

    @Override
    public List<Seller> getAllSeller() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller getSellerById(String id) {
        return sellerRepository.findById(id).get();
    }

    @Override
    public Seller getSellerByEmail(String email) {
        return sellerRepository.findSellerByEmail(email);
    }

    @Override
    public void deleteSeller(String id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public List<Seller> searchSellerByName(String sellerName) {
        return sellerRepository.findSellerBynameSellerContainingIgnoreCase(sellerName);
    }
}
