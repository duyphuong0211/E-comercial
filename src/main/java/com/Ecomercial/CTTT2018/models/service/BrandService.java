package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddBrandForm;
import com.Ecomercial.CTTT2018.models.domain.Brand;

import java.util.Collection;

public interface BrandService {

    Collection<Brand> getAllBrands();

    Brand addBrand(AddBrandForm form);
}
