package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.models.domain.StoreProduct;

import java.util.Optional;

public interface StoreProductService {

    Optional<StoreProduct> getProductById(Long id);

    void incrementViews(Long storeProductId);

}
