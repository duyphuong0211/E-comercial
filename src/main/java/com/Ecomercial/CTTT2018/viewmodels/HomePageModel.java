package com.Ecomercial.CTTT2018.viewmodels;

import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class HomePageModel {
    @Autowired
    ProductService productService;

    //Getting all products
    public HashMap<String, Object> create() {
        HashMap<String, Object> model = new HashMap<>();
        Collection<Product> products=productService.getAllProducts();
        model.put("products",products);
        return model;
    }

}
