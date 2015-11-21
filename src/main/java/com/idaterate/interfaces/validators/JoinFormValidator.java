package com.idaterate.interfaces.validators;

import com.idaterate.domain.User.IUserRepository;
import com.idaterate.infrastructure.service.SettingsService;
import com.idaterate.infrastructure.settings.Settings;
import com.idaterate.interfaces.dtos.JoinFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;

@Component
public class JoinFormValidator implements Validator {

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return JoinFormDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinFormDTO joinFormDTO = (JoinFormDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "value.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "value.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "value.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "value.required");

        if(!joinFormDTO.isAgreeToEmail()) {
            errors.rejectValue("agreeToEmail", "value.required");
        }

        if(settingsService.getSettingValue(Settings.RECAPTCHA_SITE_KEY) != null &&
                settingsService.getSettingValue(Settings.RECAPTCHA_SECRET_KEY) != null) {
            RestTemplate restTemplate = new RestTemplate();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("secret", settingsService.getSettingValue(Settings.RECAPTCHA_SECRET_KEY));
            params.add("response", joinFormDTO.getRecaptcha());

            RecaptchaResponse recaptchaResponse = restTemplate.postForEntity(
                    settingsService.getSettingValue(Settings.RECAPTCHA_URL), params, RecaptchaResponse.class).getBody();

            if (!recaptchaResponse.isSuccess()) {
                errors.rejectValue("recaptcha", "recaptcha.error");
            }
        }

        // Unique email and username
        if(userRepository.findByUsername(joinFormDTO.getUsername()) != null) {
            errors.rejectValue("username", "join.username_unique_error");
        }

        if(userRepository.findByEmail(joinFormDTO.getEmail()) != null) {
            errors.rejectValue("email", "join.email_unique_error");
        }

    }

}
