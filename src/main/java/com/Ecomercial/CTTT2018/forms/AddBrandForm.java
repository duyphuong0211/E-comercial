package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Getter
@Setter
public class AddBrandForm {

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name="";


}