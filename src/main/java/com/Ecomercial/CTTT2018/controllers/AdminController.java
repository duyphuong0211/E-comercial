package com.Ecomercial.CTTT2018.controllers;

import com.Ecomercial.CTTT2018.forms.AddBrandForm;
import com.Ecomercial.CTTT2018.forms.AddBrandFormValidator;
import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.domain.Brand;
import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.service.BrandService;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.models.service.StoreService;
import com.Ecomercial.CTTT2018.validators.AddProductFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;


@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(AdminController.class);

    /////////////////////////*  SERVICES, REPOSITORIES AND VALIDATORS SECTION  */////////////////////////////
    @Autowired
    private BrandService brandService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private AddBrandFormValidator brandFormValidator;

    @Autowired
    private AddProductFormValidator addProductFormValidator;

    //	@Autowired
//	private AddStoreFormValidator addStoreFormValidator;
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

    //	@InitBinder("addStoreForm")
//	public void addStoreFormInitBinder(WebDataBinder binder) {
//		// This maps the add brand form to our own validator.
//		binder.addValidators(addStoreFormValidator);
//	}

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addbrand", method = RequestMethod.GET)
    public ModelAndView addBrand(@ModelAttribute("addBrandForm") AddBrandForm addBrandForm) {

        logger.info("AdminController: Show add brand page(Get)");
        return new ModelAndView("admin/addbrand", "addBrandForm", addBrandForm);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addbrand", method = RequestMethod.POST)
    public ModelAndView addBrand(@Valid @ModelAttribute("addBrandForm")AddBrandForm addBrandForm, BindingResult bindingResult)
    {

        logger.info("Admin Controller: show add brand page(Post)");
        if(bindingResult.hasErrors())
            return new ModelAndView("admin/addbrand","addBrandForm",addBrandForm);
        brandService.addBrand(addBrandForm);
        return new ModelAndView("redirect:/");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.GET)
    public ModelAndView addProduct(@ModelAttribute("addProductForm") AddProductForm addProductForm) {

        logger.info("Admin Controller: show add product page(Get)");
        Collection<Brand> allBrands=brandService.getAllBrands();
        ModelAndView mv=new ModelAndView("admin/addproduct");
        mv.addObject("addProductForm",addProductForm);
        mv.addObject("brands",allBrands);
        return mv;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute("addProductForm") AddProductForm addProductForm, BindingResult bindingResult) {

        logger.info("Admin Controller: show add product page(Post)");
        Collection<Brand>allBrands=brandService.getAllBrands();
        ModelAndView mv = new ModelAndView("admin/addproduct");
        mv.addObject("addProductForm",addProductForm);
        mv.addObject("brands",allBrands);
        if (bindingResult.hasErrors())
            return mv;

        Product product=productService.addProduct(addProductForm);
        long id = product.getId();
        return new ModelAndView("redirect:/product/view"+id);
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/acceptStore/{id}", method = RequestMethod.GET)
    public ModelAndView viewAndAcceptStore(@PathVariable("id") long id) {

        logger.info("Admin Controller: show accept store page(get)");
        Optional<Store> store = storeService.getStoreById(id);
        // If the store wasn't found
        if (!store.isPresent()) {
            return new ModelAndView("error/404");
        }
        return new ModelAndView("store/accept", "store", store);
    }

    //	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/acceptStore/{id}", method = RequestMethod.POST)
    public ModelAndView acceptStore(@PathVariable("id") long id) {

        logger.info("Admin Controller: show accept store page(post)");
        storeService.acceptStore(id);
        return new ModelAndView("redirect:/"); // Temporary
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////
}