package com.Ecomercial.CTTT2018.controllers;

import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import com.Ecomercial.CTTT2018.models.domain.Product;
import com.Ecomercial.CTTT2018.models.domain.StoreProduct;
import com.Ecomercial.CTTT2018.models.service.PhysicalProductService;
import com.Ecomercial.CTTT2018.models.service.ProductService;
import com.Ecomercial.CTTT2018.models.service.StoreProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
    /////////////////////////*  SERVICES, REPOSITORIES AND VALIDATORS SECTION  */////////////////////////////

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreProductService storeProductService;

    @Autowired
    private PhysicalProductService physicalProductService;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/product/view/{id}", method = RequestMethod.GET)
    public ModelAndView viewProduct(@PathVariable("id") Long id) {

        logger.info("Product Controller: show product view page(get)");
        Optional<Product> product = productService.getProductById(id);
        if (!product.isPresent()) {
            return new ModelAndView("error/404");
        }
        return new ModelAndView("product/view", "product", product.get());
    }

    @RequestMapping(value = "/store/products/{id}", method = RequestMethod.GET)
    public ModelAndView viewStoreProduct(@PathVariable("id") Long id) {
        Optional<StoreProduct> product = storeProductService.getProductById(id);
        if (!product.isPresent()) {
            return new ModelAndView("error/404");
        }
        Optional<PhysicalProduct>physicalProduct=physicalProductService.getProductbyId(product.get().getProduct().getId());
        ModelAndView mv=new ModelAndView("product/storeprodcutview");
        product.get().getStore().getId();
        mv.addObject("product",product.get());
        if(physicalProduct.isPresent())
            mv.addObject("physicalproduct",physicalProduct.get());
        return mv;
    }
}
