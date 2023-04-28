package com.enigma.fruitmart.repository;

import com.enigma.fruitmart.dto.ProductDTO;
import com.enigma.fruitmart.entitas.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM mst_product", nativeQuery = true)
    public List<Product> getAllProduct();

    @Query(value = "SELECT * from mst_product p where p.stock < 7", nativeQuery = true)
    List<Product> findProductMinStock();

    @Query(value = "SELECT * FROM mst_product p WHERE p.product_price > :maxPrice", nativeQuery = true)
    public List<Product> getProductWithMaxPrice (Integer maxPrice);


}
