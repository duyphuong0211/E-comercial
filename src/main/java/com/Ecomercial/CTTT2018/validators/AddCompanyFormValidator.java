package com.Ecomercial.CTTT2018.validators;

import com.Ecomercial.CTTT2018.forms.AddCompanyForm;
import com.Ecomercial.CTTT2018.models.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddCompanyFormValidator implements Validator {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean supports(Class<?> clazz)
    {
        return clazz.equals(AddCompanyForm.class);
    }
    public void validate(Object target, Errors errors)
    {
        AddCompanyForm form =(AddCompanyForm) target;
        validateName(errors,form);
    }
    private void validateName(Errors errors,AddCompanyForm form)
    {
        if(errors.hasFieldErrors("name"))
            return;

        if(companyRepository.findOneByName(form.getName()).isPresent()) {
            errors.rejectValue("name","msg.DuplicateCompanyName");
        }
    }
}
