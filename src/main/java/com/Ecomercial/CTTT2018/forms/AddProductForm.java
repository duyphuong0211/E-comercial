package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AddProductForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String brand = "";

    @NotNull
    @Min(0)
    private Float price ;

}