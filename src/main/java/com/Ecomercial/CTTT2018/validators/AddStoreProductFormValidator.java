package com.Ecomercial.CTTT2018.validators;

import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.forms.AddStoreProductForm;
import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.domain.VirtualStore;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.models.service.StoreService;
import com.Ecomercial.CTTT2018.utilities.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class AddStoreProductFormValidator implements Validator {

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddStoreProductForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddStoreProductForm form = (AddStoreProductForm) target;

        Optional<Product> productOptional = productService.getProductById(form.getProductId());
        if(!productOptional.isPresent()) {
            errors.rejectValue("productId", "NotValid");
            return;
        }

        Optional<Store> storeOptional = storeService.getStoreById(form.getStoreId());
        if(!storeOptional.isPresent()) {
            errors.rejectValue("storeId", "NotValid");
            return;
        }

        Product product = productOptional.get();
        Store store = storeOptional.get();

        CurrentUser currentUser = AuthUtil.getCurrentUser();
        if(currentUser.getId() != store.getStoreOwner().getId())
            errors.reject("Unauthorized!!!!");

        //Check Type
        if(store instanceof VirtualStore && product instanceof PhysicalProduct)
            errors.rejectValue("productId", "msg.VirtualStoreProducts");

    }
}