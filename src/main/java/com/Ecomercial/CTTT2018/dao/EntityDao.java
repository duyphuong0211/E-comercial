package com.Ecomercial.CTTT2018.dao;


import java.util.Collection;

public interface EntityDao<T> {
    Collection<T> getAllEntities();

    T getEntityById(String  id);

    boolean removeEntityById(String id);

    boolean updateEntity(T entity);

    boolean insertEntityToDb(T entity);
}
