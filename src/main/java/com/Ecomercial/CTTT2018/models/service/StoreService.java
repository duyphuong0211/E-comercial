package com.Ecomercial.CTTT2018.models.service;


import com.Ecomercial.CTTT2018.forms.AddStoreForm;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface StoreService {

    Optional<Store> getStoreById(long id);

    void acceptStore(long storeId);

    Collection<Store> getAllStores();

    Store add(AddStoreForm form, User user);
}
