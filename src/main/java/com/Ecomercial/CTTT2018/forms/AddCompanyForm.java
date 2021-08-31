package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AddCompanyForm {

    @NotEmpty
    private String name="";
}
