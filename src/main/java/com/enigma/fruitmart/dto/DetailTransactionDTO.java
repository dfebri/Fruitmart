package com.enigma.fruitmart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailTransactionDTO {
    private String nameProduct;
    private Integer quantity;
    private Integer priceSell;
    private Integer subTotal;

}
