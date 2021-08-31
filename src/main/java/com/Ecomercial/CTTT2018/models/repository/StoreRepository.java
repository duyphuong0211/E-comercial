package com.Ecomercial.CTTT2018.models.repository;

import com.Ecomercial.CTTT2018.models.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findOneById(long id);
}
