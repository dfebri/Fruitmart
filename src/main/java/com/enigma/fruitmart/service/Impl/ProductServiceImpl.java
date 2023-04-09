package com.enigma.fruitmart.service.Impl;

import com.enigma.fruitmart.dto.ProductDTO;
import com.enigma.fruitmart.entitas.Product;
import com.enigma.fruitmart.entitas.Seller;
import com.enigma.fruitmart.repository.ProductRepository;
import com.enigma.fruitmart.service.ProductService;
import com.enigma.fruitmart.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    SellerService sellerService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, SellerService sellerService) {
        this.productRepository = productRepository;
        this.sellerService = sellerService;
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
    public ProductDTO getProductDTOById(String id) {
        if (productRepository.findById(id).isPresent()) {
            Product product = productRepository.findById(id).get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductid(product.getId());
            productDTO.setNameProduct(product.getNameProduct());
            productDTO.setProductPrice(product.getProductPrice());
            productDTO.setStock(product.getStock());
            return productDTO;
        } else throw new NoSuchElementException();
    }

    @Override
    public Product saveProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        Seller seller = sellerService.getSellerById(saveProduct.getSeller().getId());
        saveProduct.setSeller(seller);
        return saveProduct;

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
