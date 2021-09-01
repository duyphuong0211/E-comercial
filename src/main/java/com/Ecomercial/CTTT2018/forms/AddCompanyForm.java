package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddCompanyForm {

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name="";
}
