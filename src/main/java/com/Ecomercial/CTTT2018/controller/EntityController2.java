package com.Ecomercial.CTTT2018.controller;

import com.Ecomercial.CTTT2018.entity.Entity;
import com.Ecomercial.CTTT2018.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/entities")
public class EntityController2 {

    @Autowired
    private EntityService entityService;

    @GetMapping("/all")
    public String getAllEntities(Model model) {
        Collection<Entity> entities = entityService.getAllEntities();
        model.addAttribute("entities"  , entities );
        return "entities/index";
    }

    @GetMapping("all/{id}")
    public String getEntityById(@PathVariable("id") int id, Model modelMap) {

        Entity entity = entityService.getEntityById(id);

        //Pass to View
        modelMap.addAttribute("id"  , entity.getId()  );
        modelMap.addAttribute("name", entity.getName());
        modelMap.addAttribute("desc", entity.getDesc());

        return "entities/view";
    }
}
