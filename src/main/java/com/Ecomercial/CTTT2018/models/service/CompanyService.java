package com.Ecomercial.CTTT2018.models.service;

import com.Ecomercial.CTTT2018.forms.AddCompanyForm;
import com.Ecomercial.CTTT2018.models.domain.Company;

import java.util.Collection;

public interface CompanyService {

    Collection<Company> getAllCompanies();

    Company addCompany(AddCompanyForm form);
}
