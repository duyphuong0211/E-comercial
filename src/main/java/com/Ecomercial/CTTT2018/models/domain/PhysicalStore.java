package com.Ecomercial.CTTT2018.models.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class PhysicalStore extends Store {

    private String address;
}
