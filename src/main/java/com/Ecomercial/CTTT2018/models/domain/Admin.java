package com.Ecomercial.CTTT2018.models.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Admin {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

}
