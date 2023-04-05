package com.enigma.simpleproduct.entitas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_product")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id_product")
    private String id;
    private String nameProduct;
    private Integer productPrice;
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

}
