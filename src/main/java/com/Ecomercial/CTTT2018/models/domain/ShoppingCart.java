package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "shoppingCart", orphanRemoval = false)
    private List<Order> orders;

}
