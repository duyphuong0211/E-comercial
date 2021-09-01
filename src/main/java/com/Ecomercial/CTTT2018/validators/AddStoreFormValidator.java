package com.Ecomercial.CTTT2018.validators;

import com.Ecomercial.CTTT2018.auth.CurrentUser;
import com.Ecomercial.CTTT2018.forms.AddStoreForm;
import com.Ecomercial.CTTT2018.models.repository.StoreRepository;
import com.Ecomercial.CTTT2018.utilities.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddStoreFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddStoreForm.class);
    }

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public void validate(Object target, Errors errors) {

        AddStoreForm form = (AddStoreForm) target;
        if(form.getIsPhysical())
            validatePhysical(errors, form);

        CurrentUser user = AuthUtil.getCurrentUser();

        validateUniqueName(errors, form, user);

    }

    private void validatePhysical(Errors errors,AddStoreForm form) {

        if(form.getAddress().length() < 2 || form.getAddress().length() > 200)
            errors.rejectValue("address","msg.AddressSizeRange");
    }

    private void validateUniqueName(Errors errors,AddStoreForm form, CurrentUser user) {

        if(errors.hasFieldErrors("name"))
            return;

        if(storeRepository.findByStoreOwner_IdAndName(user.getId(), form.getName()).size() > 0){
            errors.rejectValue("name","msg.DuplicateStoreNameSameOwner");
        }
    }

}
