package com.Ecomercial.CTTT2018.controller;

import com.Ecomercial.CTTT2018.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private EntityService entityService;
    public UserController()
    {


    }



    /*@RequestMapping("/all" )
    public List<User> getall()
    {
        return FakeEntityDaoImpl.users;
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public List<User>register(@RequestBody User user)
    {
        users.add(user);
        return users;
    }*/

}
