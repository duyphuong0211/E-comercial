package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;

import java.util.Optional;

public interface PhysicalProductService {

    Optional<PhysicalProduct> getProductbyId(Long id);

}
