package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class AddBrandForm {

    @NotEmpty
    private String name="";

    @Override
    public String toString() {
        return "AddBrandForm{" +
                "name='" + name + '\'' +
                '}';
    }
}