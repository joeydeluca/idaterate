package com.idaterate.interfaces.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.idaterate.domain.DateRate;

@Component
public class DateRateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return DateRate.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateRate dateRate = (DateRate) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateUsername", "value.required");
        
        if("-1".equals(dateRate.getDatingSite())) {
            errors.reject("datingSite", "value.required");
        }
        
      
    }

}
