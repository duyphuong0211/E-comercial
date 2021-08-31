package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

}