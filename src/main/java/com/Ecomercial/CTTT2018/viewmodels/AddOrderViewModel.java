package com.Ecomercial.CTTT2018.viewmodels;

import com.Ecomercial.CTTT2018.forms.AddOrderForm;
import com.Ecomercial.CTTT2018.models.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AddOrderViewModel {


    @Autowired
    private StoreProductService storeProductService;

    public HashMap<String, Object> create(AddOrderForm form, Long storeProductId) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("form"        , form);
        model.put("product"      , storeProductService.getProductById(storeProductId).get());
        return model;
    }
}
