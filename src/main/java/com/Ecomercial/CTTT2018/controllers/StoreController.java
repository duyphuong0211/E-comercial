package com.Ecomercial.CTTT2018.controllers;

import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.forms.AddStoreForm;
import com.Ecomercial.CTTT2018.models.domain.Role;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.service.StoreService;
import com.Ecomercial.CTTT2018.utilities.AuthUtil;
import com.Ecomercial.CTTT2018.validators.AddStoreFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StoreController {

    /////////////////////////*  SERVICES, REPOSITORIES AND VALIDATORS SECTION  */////////////////////////////
    @Autowired
    private StoreService storeService;

    @Autowired
    private AddStoreFormValidator addStoreFormValidator;

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////*  VALIDATORS BINDING SECTION  *//////////////////////////////////////

    @InitBinder("addStoreForm")
    public void addBrandFormInitBinder(WebDataBinder binder) {
        binder.addValidators(addStoreFormValidator);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////

    @RequestMapping(value = "/store/add", method = RequestMethod.GET)
    public ModelAndView addStore(@ModelAttribute("addStoreForm") AddStoreForm addStoreForm) {
        return new ModelAndView("store/add", "addStoreForm", addStoreForm);
    }

    @RequestMapping(value = "/store/add", method = RequestMethod.POST)
    public ModelAndView addStore(@Valid @ModelAttribute("addStoreForm")AddStoreForm addStoreForm, BindingResult bindingResult, CurrentUser currentUser)
    {
        if(bindingResult.hasErrors())
            return new ModelAndView("store/add","AddStoreForm",addStoreForm);

        Store x = storeService.add(addStoreForm, currentUser.getUser());

        if(true)
            //Add Role to Runtime Session
            AuthUtil.addRoleAtRuntime(Role.STORE_OWNER);

        return new ModelAndView("redirect:/");
    }

}