package com.Ecomercial.CTTT2018.validators;

import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.service.BrandService;
import com.Ecomercial.CTTT2018.models.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Component
public class AddProductViewModel {

    @Autowired
    BrandService brandService;

    @Autowired
    CompanyService companyService;

    //Query for Brands/Companies using the view model!.
    public HashMap<String, Object> create(AddProductForm form) {

        HashMap<String, Object> model = new HashMap<>();
        model.put("addProductForm"  , form);
        model.put("brands"          , brandService.getAllBrands());
        model.put("companies"       , companyService.getAllCompanies());
        return model;
    }

    public ModelAndView modelAndView(String path, AddProductForm form) {

        ModelAndView modelAndView = new ModelAndView(path);
        modelAndView.addObject("addProductForm"  , form);
        modelAndView.addObject("brands"          , brandService.getAllBrands());
        modelAndView.addObject("companies"       , companyService.getAllCompanies());
        return modelAndView;
    }
}

