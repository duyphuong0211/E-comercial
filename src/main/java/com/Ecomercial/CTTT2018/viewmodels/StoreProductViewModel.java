package com.Ecomercial.CTTT2018.viewmodels;

import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import com.Ecomercial.CTTT2018.models.domain.StoreProduct;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class StoreProductViewModel {

    //Check if Product is Physical/Virtual
    public HashMap<String, Object> create(StoreProduct storeProduct) {
        HashMap<String, Object> model = new HashMap<>();
        model.put("product"  , storeProduct);


        PhysicalProduct physicalProduct = null;
        if(storeProduct.getProduct() instanceof PhysicalProduct)
            physicalProduct =  (PhysicalProduct) storeProduct.getProduct();

        model.put("physicalproduct"  , physicalProduct);
        return model;
    }

}
