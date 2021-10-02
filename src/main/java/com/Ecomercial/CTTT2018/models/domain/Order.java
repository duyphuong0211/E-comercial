package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "addedDate", nullable = false)
    private Date addedDate;

    @Column(name = "processedDate")
    private Date processedDate;

    @Column(name = "quantity", nullable = false)
    private int quantity = 1;

    @Column(name = "address",nullable = false)
    private String address;

    //Processed true = bought by the user.
    @Column(name = "processed", nullable = false)
    private boolean processed = false;

    @ManyToOne
    private StoreProduct storeProduct;



    //TODO Index this.
    @ManyToOne
    private User user;

    public Order(User user, StoreProduct storeProduct, int quantity) {
        this.storeProduct = storeProduct;
        this.quantity = quantity;
        this.user = user;
        this.addedDate = new Date();
    }

}
