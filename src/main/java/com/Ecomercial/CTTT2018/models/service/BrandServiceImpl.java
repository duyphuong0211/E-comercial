package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddBrandForm;
import com.Ecomercial.CTTT2018.models.domain.Brand;
import com.Ecomercial.CTTT2018.models.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Collection<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand addBrand(AddBrandForm form) {
        Brand brand=new Brand();
        brand.setName(form.getName());
        return brandRepository.save(brand);
    }
}
