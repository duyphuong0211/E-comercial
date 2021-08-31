package com.Ecomercial.CTTT2018.models.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    private String name;
    @OneToMany(mappedBy = "company")
    private List<Product> products;

}
