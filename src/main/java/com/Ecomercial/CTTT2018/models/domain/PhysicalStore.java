package com.Ecomercial.CTTT2018.models.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue(value = "physical")
public class PhysicalStore extends Store {

    private String address;
}
