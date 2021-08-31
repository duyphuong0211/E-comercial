package com.Ecomercial.CTTT2018.models.repository;

import com.Ecomercial.CTTT2018.models.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findOneByName(String name);

    List<Company> findAll();
}
