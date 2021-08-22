package com.Ecomercial.CTTT2018.service;

import com.Ecomercial.CTTT2018.dao.EntityDao;
import com.Ecomercial.CTTT2018.entity.Entity;
import com.Ecomercial.CTTT2018.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EntityService {

    @Autowired
    @Qualifier("fakeData")
    private EntityDao entityDao;

    public Collection<User> getAllEntities() {
        return this.entityDao.getAllEntities();
    }

    public User getEntityById(int id) {
        return this.entityDao.getEntityById(id);
    }

    public void removeEntityById(int id) {
        this.entityDao.removeEntityById(id);
    }

    public void updateEntity(User user) {
        this.entityDao.updateEntity(user);
    }

    public void insertEntity(User user) {
        this.entityDao.insertEntityToDb(user);
    }
}