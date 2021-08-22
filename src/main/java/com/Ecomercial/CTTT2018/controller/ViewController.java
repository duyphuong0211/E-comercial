package com.Ecomercial.CTTT2018.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/")
    public String index(ModelMap modelmap)
    {
        modelmap.put("hello","aad");
        return "entities/index";
    }
}
