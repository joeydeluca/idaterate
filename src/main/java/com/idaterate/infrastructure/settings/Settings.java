package com.idaterate.infrastructure.settings;

/**
 * Created by Joe Deluca on 17/10/2015.
 */
public enum Settings {
    API_CODE("API_CODE", "API_CODE"),
    RECAPTCHA_SITE_KEY("RECAPTCHA_SITE_KEY", null),
    RECAPTCHA_SECRET_KEY("RECAPTCHA_SECRET_KEY", null),
    RECAPTCHA_URL("RECAPTCHA_URL", "https://www.google.com/recaptcha/api/siteverify")
    ;

    private final String key;
    private final String defaultValue;

    Settings(String key, String defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
    }

    public String getKey() {
        return key;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
