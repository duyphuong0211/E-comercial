package com.Ecomercial.CTTT2018.controllers;


import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.models.repository.UserRepository;
import com.Ecomercial.CTTT2018.viewmodels.HomePageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HomePageModel homePageModel;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("home/index", homePageModel.create());
	}

}
