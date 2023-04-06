package com.enigma.fruitmart.controller;

import com.enigma.fruitmart.entitas.Seller;
import com.enigma.fruitmart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "sellers")
public class SellerController {
    SellerService sellerService;
    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping
    public Seller saveSeller (@RequestBody Seller seller){
        return sellerService.saveSeller(seller);
    }

    @PutMapping
    public Seller updateSeller (@RequestBody Seller seller){
        return sellerService.updateSeller(seller);
    }

    @GetMapping("/list")
    public List<Seller> getAllSeller(){
        return sellerService.getAllSeller();
    }

    @GetMapping("/find-id")
    public Seller getSellerById (@RequestParam(name ="id") String id){
        return sellerService.getSellerById(id);
    }

    @GetMapping("{email}")
    public Seller getSellerByEmail(@PathVariable String email){
        return sellerService.getSellerByEmail(email);
    }

    @GetMapping("/search-name")
    public List<Seller> searchSellerByName (@RequestParam(name = "sellerName") String sellerName){
        return sellerService.searchSellerByName(sellerName);
    }

    @DeleteMapping("{id}")
    public void deleteSeller (@PathVariable String id){
        sellerService.deleteSeller(id);
    }
}
