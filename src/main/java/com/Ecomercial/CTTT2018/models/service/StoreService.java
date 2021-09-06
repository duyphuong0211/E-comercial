package com.Ecomercial.CTTT2018.models.service;


import com.Ecomercial.CTTT2018.forms.AddStoreForm;
import com.Ecomercial.CTTT2018.forms.AddStoreProductForm;
import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.domain.StoreProduct;
import com.Ecomercial.CTTT2018.models.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface StoreService {

    Optional<Store> getStoreById(Long id);

    void acceptStore(Long storeId);

    Collection<Store> getAllStores();

    Collection<Store> getAllAppliedStores();

    Collection<Store> getAllAcceptedUserStores(Long storeOwnerId);

    Collection<Store> getAllPendingUserStores(Long storeOwnerId);

    Collection<Store> getAllNotAcceptedUserStores(Long storeOwnerId);

    Store add(AddStoreForm form, User user);

    StoreProduct addProductToStore(AddStoreProductForm form, User user);
}
