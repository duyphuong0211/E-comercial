package com.Ecomercial.CTTT2018.models.repository;


import com.Ecomercial.CTTT2018.models.domain.PhysicalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhysicalProductRepository extends JpaRepository<PhysicalProduct, Long> {
    Optional<PhysicalProduct> findById(Long id);
}
