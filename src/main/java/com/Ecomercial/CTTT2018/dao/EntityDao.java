package com.Ecomercial.CTTT2018.dao;

import com.Ecomercial.CTTT2018.entity.Entity;
import com.Ecomercial.CTTT2018.entity.User;

import java.util.Collection;

public interface EntityDao {
    Collection<User> getAllEntities();

    User getEntityById(int id);

    void removeEntityById(int id);

    void updateEntity(User entity);

    void insertEntityToDb(User entity);
}
