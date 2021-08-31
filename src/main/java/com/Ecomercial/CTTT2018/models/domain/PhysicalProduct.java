package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class PhysicalProduct extends Product {

    private float weight;

    private float length;

    private float width;

    private float height;

}
