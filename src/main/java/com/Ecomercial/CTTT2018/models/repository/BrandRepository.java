package com.Ecomercial.CTTT2018.models.repository;

import com.Ecomercial.CTTT2018.models.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findOneByName(String name);

    List<Brand> findAll();
}
