package com.Ecomercial.CTTT2018.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/")
	public String Index() {

		return "home/index";
	}
}