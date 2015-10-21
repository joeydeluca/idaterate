package com.idaterate.infrastructure.settings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joe Deluca on 15/10/2015.
 */
public class DefaultSettings {
    public final static Map<String, String> getDefaultSettings() {
        final Map<String, String> defaultSettings = new HashMap<>();

        defaultSettings.put(Settings.API_CODE, "1234");

        return defaultSettings;
    }
}
