package com.enigma.fruitmart.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;

@Setter
@Getter
public class ProductDTO {
    private String productid;
    private String nameProduct;
    private Integer productPrice;
    private Integer stock;


}
