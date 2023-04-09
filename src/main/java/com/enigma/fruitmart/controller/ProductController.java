package com.enigma.fruitmart.controller;

import com.enigma.fruitmart.dto.ProductDTO;
import com.enigma.fruitmart.entitas.Product;
import com.enigma.fruitmart.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id){
        return productService.getProductById(id);
    }

    @GetMapping("/DTO/{id}")
    public ProductDTO getProductDTOByID(@PathVariable String id){
        return productService.getProductDTOById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam (name = "id") String id) {
        productService.delete(id);
    }

    @GetMapping
    public Page<Product> getproductPerPage(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                           @RequestParam(name = "size", defaultValue = "3      ") Integer sizePerPage){
        Pageable pageable = PageRequest.of(page, sizePerPage);
        return productService.getProductPerPage(pageable);
    }

    @GetMapping("/list")
    public List<Product> getAllProductList (){
        return productService.getAllProduct();
    }

    @GetMapping("/min-stock")
    public List<Product> getProductMinStock(){
        return productService.findProductMinStock();
    }

}
