package com.idaterate.interfaces.validators;

import com.idaterate.domain.DatingScore;
import com.idaterate.domain.DatingSite;
import com.idaterate.interfaces.dtos.DateRateDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.idaterate.domain.DateRate;

@Component
public class DateRateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return DateRateDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        DateRateDTO dateRate = (DateRateDTO) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateUsername", "value.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "value.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hashtags", "value.required");

        if(DatingSite.PLEASE_CHOOSE.getId().equals(dateRate.getPredefinedDatingSite())) {
            errors.rejectValue("predefinedDatingSite", "value.required");
        }

        if(DatingScore.PLEASE_CHOOSE.getId().equals(dateRate.getScore()+"")) {
            errors.rejectValue("score", "value.required");
        }

        if(DatingSite.OTHER.getId().equals(dateRate.getPredefinedDatingSite()) &&
                (dateRate.getUserDefinedDatingSite() == null || dateRate.getUserDefinedDatingSite().trim().isEmpty())) {
            errors.rejectValue("userDefinedDatingSite", "value.required");
        }
        
      
    }

}
