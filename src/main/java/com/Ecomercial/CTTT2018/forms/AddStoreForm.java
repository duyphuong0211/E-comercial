package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
@Setter
@Component
public class AddStoreForm {

    @NotEmpty
    @Length(max = 140, min = 3)
    private String name = "";

    private Boolean isPhysical = true;

    private String Address;

}
