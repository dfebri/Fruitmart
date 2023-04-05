package com.enigma.simpleproduct.entitas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table
@Entity(name = "mst_seller")
@NoArgsConstructor
@Setter
@Getter
public class Seller {
    @Id
    @Column(name = "id_seller")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String nameSeller;
    @Column(nullable = false)
    private String email;
    private Integer numberPhone;
    private String address;
}
