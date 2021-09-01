package com.Ecomercial.CTTT2018.models.service;


import com.Ecomercial.CTTT2018.forms.AddStoreForm;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface StoreService {

    Optional<Store> getStoreById(Long id);

    void acceptStore(Long storeId);

    Collection<Store> getAllStores();

    Collection<Store> getAllAppliedStores();

    Store add(AddStoreForm form, User user);
}
