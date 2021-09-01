package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddStoreForm;
import com.Ecomercial.CTTT2018.models.domain.*;
import com.Ecomercial.CTTT2018.models.repository.StoreRepository;
import com.Ecomercial.CTTT2018.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Store> getStoreById(Long id) {
        //return Optional.ofNullable(storeRepository.findOne(id));
        return storeRepository.findById(id); // in new version istead usde findOn -> FindByID
    }
    @Override
    public void acceptStore(Long storeId) {
        Optional<Store> store =storeRepository.findById(storeId);
        store.ifPresent(store1 -> {
            store1.setAccepted(true);
            storeRepository.save(store1);
        });
    }

    @Override
    public Collection<Store> getAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Collection<Store> getAllAppliedStores() {
        return storeRepository.findAllByAccepted(false);
    }

    @Override
    public Store add(AddStoreForm form, User sessionUser) {
        Store store;
        if(form.getIsPhysical())
        {
            PhysicalStore physicalStore = new PhysicalStore();
            physicalStore.setAddress(form.getAddress());
            store = physicalStore;
        }
        else
            store = new VirtualStore();

        //Common Attributes
        store.setAccepted(false);
        store.setName(form.getName());

        //Add New Role to User (We query as session user can be outdated)
        //User user = userRepository.findOne(sessionUser.getId()); replacement for findOne
        User user = userRepository.findById(sessionUser.getId()).orElse(null);

        if(!user.getRoles().contains(Role.STORE_OWNER))
            user.addRole(Role.STORE_OWNER);

        //First Time StoreOwner (create storeowner row in table)
        if(user.getStoreOwner() == null){
            user.setStoreOwner(new StoreOwner());
            user.getStoreOwner().setUser(user);
        }

        //save user
        user = userRepository.save(user);

        //Link Store with the StoreOwner of LoggedUser(Delegation)
        store.setStoreOwner(user.getStoreOwner());

        return storeRepository.save(store);
    }
}