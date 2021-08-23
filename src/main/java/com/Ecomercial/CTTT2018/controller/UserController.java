package com.Ecomercial.CTTT2018.controller;

import com.Ecomercial.CTTT2018.entity.User;
import com.Ecomercial.CTTT2018.service.EntityService;
import com.Ecomercial.CTTT2018.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//	@RequestMapping("/all")
//	public List<User> getall() {
//		return users;
//	}

    //view in web
    @RequestMapping(value = "/register")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "entities/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {
        userService.addUser(user);
        return "entities/register";
    }

}
