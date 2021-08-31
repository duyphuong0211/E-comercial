package com.Ecomercial.CTTT2018.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String Index() {

		logger.info("Home Controller: Show Home Pgae");

		return "home/index";
	}

}
