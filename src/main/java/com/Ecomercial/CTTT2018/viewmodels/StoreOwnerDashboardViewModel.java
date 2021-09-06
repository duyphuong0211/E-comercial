package com.Ecomercial.CTTT2018.viewmodels;

import com.Ecomercial.CTTT2018.models.domain.Store;
import com.Ecomercial.CTTT2018.models.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;

@Component
public class StoreOwnerDashboardViewModel {

    @Autowired
    StoreService storeService;

    //Get User Stores.
    public HashMap<String, Object> create(Long Id) {
        HashMap<String, Object> model = new HashMap<>();
        Collection<Store> Accepted=storeService.getAllAcceptedUserStores(Id);
        Collection<Store> Pending=storeService.getAllPendingUserStores(Id);
        Collection<Store> Rejected=storeService.getAllNotAcceptedUserStores(Id);
        model.put("accepted",Accepted);
        model.put("pending",Pending);
        model.put("rejected",Rejected);
        return model;
    }

}
