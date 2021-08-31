package com.Ecomercial.CTTT2018.controllers;

import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.service.StoreService;
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
public class StoreController {

    Logger logger = LoggerFactory.getLogger(StoreController.class);

/////////////////////////*  SERVICES, REPOSITORIES AND VALIDATORS SECTION  */////////////////////////////
    @Autowired
    private StoreService storeService;

//	@Autowired
//	private AddStoreFormValidator addStoreFormValidator;

    //////////////////////////////////*  VALIDATORS BINDING SECTION  *//////////////////////////////////////

//	@InitBinder("addStoreForm")
//	public void addStoreFormInitBinder(WebDataBinder binder) {
//		// This maps the add brand form to our own validator.
//		binder.addValidators(addStoreFormValidator);
//	}

    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/store/accept/{id}", method = RequestMethod.GET)
    public ModelAndView viewAndAcceptStore(@PathVariable("id") long id) {

        logger.info("Store Controller: Show accept store page(Get)");
        Optional<Store> store = storeService.getStoreById(id);
        // If the store wasn't found
        if (!store.isPresent()) {
            return new ModelAndView("error/404");
        }

        return new ModelAndView("store/accept", "store", store);
    }

    //	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/store/accept/{id}")
    public ModelAndView acceptStore(@PathVariable("id") long id) {

        logger.info("Store Controller: Show accept store page");
        storeService.acceptStore(id);
        return new ModelAndView("redirect:/"); // Temporary
    }
}