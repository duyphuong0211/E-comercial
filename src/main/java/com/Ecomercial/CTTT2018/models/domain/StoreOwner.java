package com.Ecomercial.CTTT2018.models.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class StoreOwner {

    @Id
    protected Long id;

    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(mappedBy = "storeOwner")
    private List<Store> stores;

}
