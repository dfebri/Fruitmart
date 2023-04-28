package com.enigma.fruitmart.repository;

import com.enigma.fruitmart.dto.ProductDTO;
import com.enigma.fruitmart.entitas.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getAllProduct(){
        List<Product> productList = productRepository.getAllProduct();
        productList.forEach(e ->{
            System.out.println(e);
        });
    }

    @Test
    public void getProductWithProductMaxPrice() {
        Integer maxPrice = 20000;
        List<Product> productList = productRepository.getProductWithMaxPrice(maxPrice);
        productList.forEach(System.out::println);
    }

    @Test
    public void getProductMinStock (){
        List<Product> minStock = productRepository.findProductMinStock();
        minStock.forEach(e -> System.out.println(e));

    }




}