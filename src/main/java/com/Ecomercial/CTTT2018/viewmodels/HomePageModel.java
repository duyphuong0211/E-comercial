package com.Ecomercial.CTTT2018.viewmodels;

import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.domain.StoreProduct;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.models.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class HomePageModel {
    @Autowired
    StoreProductService storeProductService;

    //Getting all products
    public HashMap<String, Object> create() {
        HashMap<String, Object> model = new HashMap<>();
        Collection<StoreProduct> products=storeProductService.getAll();
        model.put("products",products);
        return model;
    }
}
