package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.models.domain.Order;
import com.Ecomercial.CTTT2018.models.domain.StoreProduct;
import com.Ecomercial.CTTT2018.models.domain.User;

import java.util.Optional;

public interface OrderService {
    Optional<Order> getOrderById(Long id);

    void addOrder(User user, StoreProduct storeProduct);
}
