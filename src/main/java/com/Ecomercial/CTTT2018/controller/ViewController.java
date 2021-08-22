package com.Ecomercial.CTTT2018.controller;

import com.Ecomercial.CTTT2018.entity.User;
import com.Ecomercial.CTTT2018.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class ViewController {

    @Autowired
    private EntityService entityService;



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login()
    {
        return "entities/login";
    }

    @RequestMapping(value= "/",method = RequestMethod.POST)
    public String validate(HttpServletRequest request,Model model)
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User u=new User("1","a",username,password,username);
        Collection<User> users=entityService.getAllEntities();
        if(users.contains(u))
        {
            model.addAttribute("username",username);
            return "entities/profile";
        }
        else
            return "entities/login";
    }
}
