package com.Ecomercial.CTTT2018.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Getter
@Setter
public class AddBrandForm {

    @NotEmpty
    private String name;
}
