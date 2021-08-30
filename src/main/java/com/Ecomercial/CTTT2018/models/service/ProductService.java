package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.domain.Product;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {

    Optional<Product>getProductById(long id);

    Optional<Product>getProductByName(String name);

    Optional<Product>getPriceBetween(double start,double end);

    Collection<Product>getAllProducts();

    Product addProduct(AddProductForm productForm);

}
