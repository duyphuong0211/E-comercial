package com.Ecomercial.CTTT2018.controller;

import com.Ecomercial.CTTT2018.entity.Entity;
import com.Ecomercial.CTTT2018.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @GetMapping("/getAll")
    public Collection<Entity> getAllEntities(){
        return entityService.getAllEntities();
    }

    @GetMapping("getByid/{id}")
    public Entity getEntityById(@PathVariable("id") int id) {
        return entityService.getEntityById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEntityById(@PathVariable("id") int id) {
        entityService.removeEntityById(id);
    }

    @PutMapping("update/")
    public void updateEntity(@RequestBody Entity entity) {
        entityService.updateEntity(entity);
    }

    @PostMapping("insert/")
    public void insertEntity(@RequestBody Entity entity) {
        entityService.insertEntity(entity);
    }

}
