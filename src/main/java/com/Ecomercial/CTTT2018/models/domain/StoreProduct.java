package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class StoreProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    private float price;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Store store;

    @OneToMany(mappedBy = "storeProduct")
    private List<Order> orders;

}
