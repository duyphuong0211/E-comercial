package com.Ecomercial.CTTT2018.models.service;


import com.Ecomercial.CTTT2018.models.domain.Store;

import java.util.Collection;
import java.util.Optional;

public interface StoreService {

    Optional<Store> getStoreById(long id);

    void acceptStore(long storeId);

    Collection<Store> getAllStores();

    // TODO
    //Store add(StoreCreateForm form);
}
