package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import com.Ecomercial.CTTT2018.models.repository.PhysicalProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhysicalProductServiceImpl implements PhysicalProductService {

    @Autowired
    private PhysicalProductRepository physicalProductRepository;

    @Override
    public Optional<PhysicalProduct> getProductbyId(Long id) {
        return physicalProductRepository.findById(id);
    }
}
