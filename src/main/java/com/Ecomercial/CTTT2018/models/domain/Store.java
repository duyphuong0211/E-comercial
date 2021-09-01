package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "store")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "storeType")
public abstract class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    protected Long id;

    @Column(name = "name", nullable = false, unique = true)
    protected String name;

    @Column(name = "accepted", nullable = false)
    protected boolean accepted;

    @ManyToOne(optional = false)
    protected StoreOwner storeOwner;

    @OneToMany(mappedBy = "store")
    protected List<StoreProduct> storeProducts;
    public List<StoreProduct> getStoreProducts() {
        return storeProducts;
    }
    public boolean addStoreProduct(StoreProduct storeProduct) {
        if(storeProducts == null)
            storeProducts = new ArrayList<>();
        return storeProducts.add(storeProduct);
    }
}