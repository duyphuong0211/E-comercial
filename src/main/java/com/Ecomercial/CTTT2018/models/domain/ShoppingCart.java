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
    private Long id;

    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "shoppingCart", orphanRemoval = false)
    private List<Order> orders;

}