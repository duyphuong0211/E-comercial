package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "name", nullable = false, updatable = true)
    private String name;

    @Column(name = "brand", nullable = false, unique = false)
    private String brand;

   /* @Column(name = "company", nullable = false, unique = false)
    private Company company;*/

    @Column(name = "price", nullable = false, unique = false)
    private Double price;

    @Column(name = "dateTime", nullable = false, unique = false)
    private Date dateTime;

    public Product() {
        this.name = "";
        this.brand = "";
        this.price = 0.0;
        this.dateTime = null;
    }

    public Product(String name, String brand, Double price, Date dateTime) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand=" + brand +
                ", price=" + price.toString() +
                ", dateTime=" + dateTime.toString() +
                '}';
    }

}
