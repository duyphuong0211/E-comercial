package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.models.domain.StoreProduct;
import com.Ecomercial.CTTT2018.models.repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreProductServiceImpl implements StoreProductService {

    @Autowired
    private StoreProductRepository storeProductRepository;

    @Override
    public Optional<StoreProduct> getProductById(Long id) {
        return storeProductRepository.findById(id);
    }

    public void incrementViews(Long storeProductId) {
        Optional<StoreProduct> product = storeProductRepository.findById(storeProductId);
        product.ifPresent(product1 -> {
            product1.setStoreViews(product1.getStoreViews()+1);
            storeProductRepository.save(product1);
        });
    }
}