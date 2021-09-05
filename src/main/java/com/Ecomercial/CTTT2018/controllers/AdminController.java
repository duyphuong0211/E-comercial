package com.Ecomercial.CTTT2018.controllers;

import com.Ecomercial.CTTT2018.forms.AddBrandForm;
import com.Ecomercial.CTTT2018.forms.AddCompanyForm;
import com.Ecomercial.CTTT2018.forms.AddProductForm;
import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.service.BrandService;
import com.Ecomercial.CTTT2018.models.service.CompanyService;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.models.service.StoreService;
import com.Ecomercial.CTTT2018.validators.AddBrandFormValidator;
import com.Ecomercial.CTTT2018.validators.AddCompanyFormValidator;
import com.Ecomercial.CTTT2018.validators.AddProductFormValidator;
import com.Ecomercial.CTTT2018.validators.AddProductViewModel;
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
    private CompanyService companyService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

    @Autowired
    private AddBrandFormValidator brandFormValidator;

    @Autowired
    private AddProductFormValidator addProductFormValidator;

    @Autowired
    private AddCompanyFormValidator addCompanyFormValidator;

    @Autowired
    private AddProductViewModel addProductViewModel;

    //	@Autowired
//	private AddStoreFormValidator addStoreFormValidator;
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////*  VALIDATORS BINDING SECTION  *//////////////////////////////////////

    @InitBinder("addBrandForm")
    public void addBrandFormInitBinder(WebDataBinder binder) { //This maps the add brand form to our own validator.
        binder.addValidators(brandFormValidator);
    }

    @InitBinder("addCompanyForm")
    public void AddCompanyFormInitBinder(WebDataBinder binder){
        binder.addValidators(addCompanyFormValidator);
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
    @RequestMapping(value = "/admin/addcompany", method = RequestMethod.GET)
    public ModelAndView addCompany(@ModelAttribute("addCompanyForm") AddCompanyForm addCompanyForm) {

        return new ModelAndView("admin/addcompany", "addCompanyForm", addCompanyForm);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addcompany", method = RequestMethod.POST)
    public ModelAndView addCompany(@Valid @ModelAttribute("addCompanyForm")AddCompanyForm addCompanyForm, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
            return new ModelAndView("admin/addcompany","addCompanyForm",addCompanyForm);
        companyService.addCompany(addCompanyForm);
        return new ModelAndView("redirect:/");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.GET)
    public ModelAndView addProduct(@ModelAttribute("addProductForm") AddProductForm addProductForm) {

        logger.info("Admin Controller: show add product page(Get)");
        return new ModelAndView("admin/addproduct", addProductViewModel.create(addProductForm));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/addproduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute("addProductForm") AddProductForm addProductForm, BindingResult bindingResult) {

        logger.info("Admin Controller: show add product page(Post)");
        if (bindingResult.hasErrors())
            return new ModelAndView("admin/addproduct", addProductViewModel.create(addProductForm));

        Product product = productService.addProduct(addProductForm);

        return new ModelAndView("redirect:/product/view/"+product.getId());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/acceptstores", method = RequestMethod.GET)
    public ModelAndView viewAppliedStore() {

        Collection<Store> stores = storeService.getAllAppliedStores();
        return new ModelAndView("admin/acceptStoreList", "stores", stores);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/acceptstores/{id}", method = RequestMethod.GET)
    public ModelAndView viewAndAcceptStore(@PathVariable("id") Long id) {

        Optional<Store> store = storeService.getStoreById(id);

        // If the store wasn't found
        if (!store.isPresent()) {
            return new ModelAndView("error/404");
        }

        return new ModelAndView("admin/acceptstore", "store", store);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/admin/acceptstores", method = RequestMethod.POST)
    public ModelAndView acceptStore(@RequestParam("id") Long id) {
        storeService.acceptStore(id);
        return new ModelAndView("redirect:/admin/acceptstores"); // Temporary
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////
}