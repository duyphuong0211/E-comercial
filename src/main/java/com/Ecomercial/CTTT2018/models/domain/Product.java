package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity     // This tells Hibernate to make a table out of this class
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, updatable = true)
    private String name;

    @Column(name = "brand", nullable = false, unique = false )
    private String brand;

   /* @Column(name = "company", nullable = false, unique = false)
    private Company company;*/

    @Column(name = "price", nullable = false, unique = false)
    private Float price;

    @Column(name = "dateTime", nullable = false, unique = false)
    private Date dateTime;

    public Product(String name, String brand, Float price, Date dateTime) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.dateTime = dateTime;
    }
}