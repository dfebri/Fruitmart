package com.enigma.fruitmart.entitas;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table
@Entity (name = "trx_detail_transaction")
@NoArgsConstructor
@Setter
@Getter
public class DetailTransaction {
    @Id
    @Column(name = "id_detail_transaction")
    @GeneratedValue (generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;
    private Integer productTransactionPrice;
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnoreProperties("detailTransactions")
    private Transaction transaction;
}
