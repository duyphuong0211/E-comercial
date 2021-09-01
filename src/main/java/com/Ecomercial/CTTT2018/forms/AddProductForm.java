package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
public class AddProductForm {

    @NotEmpty
    @Length(max = 140, min = 3)
    private String name = "";

    @NotNull
    private Integer companyId;

    @NotNull
    private Integer brandId;

    @NotNull
    @Min(0)
    private Float averagePrice;

    @NotNull
    private Boolean isPhysicalProduct = true;

    //Nullity/Empty check will be done by the custom validatior
    @Min(0)
    private Float weight;

    @Min(0)
    private Float length;

    @Min(0)
    private Float width;

    @Min(0)
    private Float height;

    private String serial;



}