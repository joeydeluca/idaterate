package com.idaterate.interfaces.validators;

import com.idaterate.domain.DatingScore;
import com.idaterate.domain.DatingSite;
import com.idaterate.infrastructure.service.SettingsService;
import com.idaterate.infrastructure.settings.Settings;
import com.idaterate.interfaces.dtos.DateRateDTO;
import com.idaterate.service.recaptcha.RecaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class DateRateValidator implements Validator {

    @Autowired
    private SettingsService settingsService;

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

        if(settingsService.getSettingValue(Settings.RECAPTCHA_SITE_KEY) != null &&
                settingsService.getSettingValue(Settings.RECAPTCHA_SECRET_KEY) != null) {
            RestTemplate restTemplate = new RestTemplate();
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("secret", settingsService.getSettingValue(Settings.RECAPTCHA_SECRET_KEY));
            params.add("response", dateRate.getRecaptcha());

            RecaptchaResponse recaptchaResponse = restTemplate.postForEntity(
                    settingsService.getSettingValue(Settings.RECAPTCHA_URL), params, RecaptchaResponse.class).getBody();

            if (!recaptchaResponse.isSuccess()) {
                errors.rejectValue("recaptcha", "recaptcha.error");
            }
        }
    }

}
