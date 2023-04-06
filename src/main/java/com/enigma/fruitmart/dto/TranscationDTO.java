package com.enigma.fruitmart.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class TranscationDTO {
    private String transactionid;
    private String customerName;
    private Integer total;
    private Date transactionDate;
    private List<DetailTransactionDTO> detailTransactionDTO;

}
