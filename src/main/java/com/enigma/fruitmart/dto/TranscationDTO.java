package com.enigma.fruitmart.dto;

import java.util.Date;
import java.util.List;

public class TranscationDTO {
    private String transactionid;
    private String customerName;
    private Integer total;
    private Date transactionDate;
    private List<DetailTransactionDTO> detailTransactionDTO;

}
