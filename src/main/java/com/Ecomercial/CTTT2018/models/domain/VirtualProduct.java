package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class VirtualProduct extends Product {

    private String serial;

}
