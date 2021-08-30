package com.Ecomercial.CTTT2018.controllers;

import com.Ecomercial.CTTT2018.forms.AddBrandForm;
import com.Ecomercial.CTTT2018.forms.AddBrandFormValidator;
import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.service.BrandService;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.validators.AddProductFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;


@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    /////////////////////////*  SERVICES, REPOSITORIES AND VALIDATORS SECTION  */////////////////////////////
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private AddBrandFormValidator brandFormValidator;

    @Autowired
    private AddProductFormValidator addProductFormValidator;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////*  VALIDATORS BINDING SECTION  *//////////////////////////////////////

    @InitBinder("addBrandForm")
    public void addBrandFormInitBinder(WebDataBinder binder) {
        binder.addValidators(brandFormValidator); //This maps the add brand form to our own validator.
    }

    @InitBinder("addProductForm")
    public void AddProductFormInitBinder(WebDataBinder binder)
    {
        binder.addValidators(addProductFormValidator);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addbrand", method = RequestMethod.GET)
    public ModelAndView addBrand(@ModelAttribute("addBrandForm") AddBrandForm addBrandForm) {

        logger.info("show addbrand page1");
        return new ModelAndView("admin/addbrand", "addBrandForm", addBrandForm);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addbrand", method = RequestMethod.POST)
    public ModelAndView addBrand(@Valid @ModelAttribute("addBrandForm")AddBrandForm addBrandForm, BindingResult bindingResult)
    {
        logger.info("show addbrand page2");
        if(bindingResult.hasErrors())
            return new ModelAndView("admin/addbrand","addBrandForm",addBrandForm);
        brandService.addBrand(addBrandForm);
        return new ModelAndView("redirect:/");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.GET)
    public ModelAndView addProduct(@ModelAttribute("addProductForm") AddProductForm addProductForm) {

        logger.info("show addproduct page");
        return new ModelAndView("admin/addproduct", "addProductForm", addProductForm);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute("addProductForm") AddProductForm addProductForm, BindingResult bindingResult) {

        logger.info("show addproduct page2");
        if (bindingResult.hasErrors())
            return new ModelAndView("admin/addproduct", "addProductForm", addProductForm);

        productService.addProduct(addProductForm);

        return new ModelAndView("redirect:/");
    }
}