package com.Ecomercial.CTTT2018.controllers;


import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.forms.UserCreateForm;
import com.Ecomercial.CTTT2018.models.service.UserService;
import com.Ecomercial.CTTT2018.validators.UserCreateFormValidator;
import com.Ecomercial.CTTT2018.viewmodels.StoreOwnerDashboardViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	/////////////////////////*  SERVICES, REPOSITORIES AND VALIDATORS SECTION  */////////////////////////////
	@Autowired
	private UserService userService;

	@Autowired
	private UserCreateFormValidator userCreateFormValidator;

	@Autowired
	private StoreOwnerDashboardViewModel storeOwnerDashboardViewModel;


	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////*  VALIDATORS BINDING SECTION  *//////////////////////////////////////


	@InitBinder("registerForm")
	public void registerFormInitBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////*  CONTROLLER ACTION  *///////////////////////////////////////////

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam Optional<String> error) {

		logger.info("Account Controller: Show login page");
		return new ModelAndView("user/login", "error", error);
	}


	//@PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #pathVariable)")
	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("registerForm") UserCreateForm registerForm) {

		logger.info("Account Controller: Show register page(Get)");
		return new ModelAndView("user/register", "registerForm", registerForm);
	}

	//@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@Valid @ModelAttribute("registerForm") UserCreateForm registerForm, BindingResult bindingResult, HttpServletRequest request) {

		logger.info("Account Controller: Show register page(Post)");
		if (bindingResult.hasErrors())
			return new ModelAndView("user/register", "registerForm", registerForm);

		//Save to DB
		userService.register(registerForm);

		//Login
		try {
			request.changeSessionId();
			request.login(registerForm.getUsername(), registerForm.getPassword());
		} catch (ServletException e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/");
	}

	@PreAuthorize("hasAuthority('STORE_OWNER')")
	@RequestMapping(value = "/user/storeowner/dashbaord", method = RequestMethod.GET)
	public ModelAndView addStoreProduct(CurrentUser currentUser) {
		return new ModelAndView("store/dashboard", storeOwnerDashboardViewModel.create(currentUser.getId()));
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////
}
