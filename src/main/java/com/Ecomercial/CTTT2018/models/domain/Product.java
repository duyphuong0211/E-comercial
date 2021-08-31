package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, updatable = true)
    private String name;

    @Column(name = "brand", nullable = false, unique = false )
    private String brand;

    @ManyToOne
    private Brand brandObj; //Obj suffix temp.

    @ManyToOne
    private Company company; //Obj suffix temp.

    @Column(name = "averagePrice", nullable = false, unique = false)
    private Float averagePrice;

    @Column(name = "dateTime", nullable = false, unique = false)
    private Date dateTime;

    @OneToMany(mappedBy = "product")
    private List<StoreProduct> storeProducts;

    public Product(){
        this.name = "";
        this.brand = "";
        this.averagePrice = 0f;
        this.dateTime = null;
    }

    public Product(String name, String brand, Float averagePrice, Date dateTime) {
        this.name = name;
        this.brand=brand;
        this.averagePrice = averagePrice;
        this.dateTime = dateTime;
    }
}