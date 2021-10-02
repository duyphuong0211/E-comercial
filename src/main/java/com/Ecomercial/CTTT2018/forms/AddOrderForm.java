package com.Ecomercial.CTTT2018.forms;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Component
public class AddOrderForm {

    @NotNull
    private int quantity = 1;

    @NotEmpty
    private String address;

    public AddOrderForm() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
