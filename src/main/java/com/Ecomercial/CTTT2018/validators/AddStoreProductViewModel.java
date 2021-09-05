package com.Ecomercial.CTTT2018.validators;

import com.Ecomercial.CTTT2018.forms.AddStoreProductForm;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.models.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AddStoreProductViewModel {

    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    public HashMap<String, Object> create(AddStoreProductForm form, Long StoreOwnerId) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("form"        , form);
        model.put("stores"      , storeService.getAllAcceptedUserStores(StoreOwnerId));
        model.put("products"    , productService.getAllProducts());
        return model;
    }
}
