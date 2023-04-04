package com.enigma.simpleproduct.service.Impl;

import com.enigma.simpleproduct.entitas.Product;
import com.enigma.simpleproduct.repository.ProductRepository;
import com.enigma.simpleproduct.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> list = productRepository.findAll();
        list.stream().filter(element -> element.getProductPrice() > 2000);
        return list;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);

    }
    @Override
    public Page<Product> getProductPerPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findProductMinStock() {
        return productRepository.findProductMinStock();
    }
}
