package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddCompanyForm;
import com.Ecomercial.CTTT2018.models.domain.Company;
import com.Ecomercial.CTTT2018.models.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Collection<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company addCompany(AddCompanyForm form) {

        Company company= new Company();

        company.setName(form.getName());
        return companyRepository.save(company);
    }
}
