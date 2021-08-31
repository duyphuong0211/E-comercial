package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;


    @Override
    public Optional<Store> getStoreById(long id) {
        return Optional.empty();
    }

    @Override
    public void acceptStore(long storeId) {

    }

    @Override
    public Collection<Store> getAllStores() {
        // TODO
        return null;
    }

    // TODO
//	@Override
//	public Store add(StoreCreateForm form) {
//		return null;
//	}
}