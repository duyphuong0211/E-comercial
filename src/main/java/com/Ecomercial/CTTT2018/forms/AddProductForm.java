package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AddProductForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String brand = "";

    @NotEmpty
    String  price ;

    @Override
    public String toString() {
        return "AddProductForm{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

}
