package com.Ecomercial.CTTT2018.models.repository;

import com.Ecomercial.CTTT2018.models.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findAllByAccepted(Boolean accepted);

    List<Store> findByStoreOwner_IdAndName(Long id, String Name);

    List<Store> findByStoreOwner_Id(Long id);

    List<Store> findByStoreOwner_IdAndAccepted(Long id, Boolean accepted);
}
