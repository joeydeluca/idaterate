package com.idaterate.interfaces.validators;

import com.idaterate.interfaces.dtos.LoginFormDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginFormDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "value.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "value.required");
    }

}
