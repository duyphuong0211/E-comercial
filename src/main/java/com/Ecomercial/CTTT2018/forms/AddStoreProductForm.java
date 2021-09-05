package com.Ecomercial.CTTT2018.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Component
public class AddStoreProductForm {

    @NotNull
    private Long storeId;

    @NotNull
    private Long productId;

    @NotNull
    @Min(0)
    private Float price;

}