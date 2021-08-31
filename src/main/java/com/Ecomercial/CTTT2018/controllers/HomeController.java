package com.Ecomercial.CTTT2018.controllers;


import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.models.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String Index(CurrentUser currentUser) {

		logger.info("Home Controller: Show Home Page");

		return "home/index";
	}

}
