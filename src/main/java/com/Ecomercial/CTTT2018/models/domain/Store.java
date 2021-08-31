package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "ownerId", nullable = false, unique = true)
    private long ownerId;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @ManyToOne
    protected UserStoreOwner userStoreOwner;

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

    public boolean setStoreProducts(List<StoreProduct> storeProducts) {
        this.storeProducts = storeProducts;
        return true;
    }

    public UserStoreOwner getUserStoreOwner() {
        return userStoreOwner;
    }

    public void setUserStoreOwner(UserStoreOwner userStoreOwner) {
        this.userStoreOwner = userStoreOwner;
    }
}