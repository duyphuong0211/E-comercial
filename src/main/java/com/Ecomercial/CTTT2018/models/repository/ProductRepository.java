package com.Ecomercial.CTTT2018.models.repository;

import com.Ecomercial.CTTT2018.models.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    Optional<Product>   findByAveragePriceBetween(Long start, Long End);

    List<Product> findAll();
}
