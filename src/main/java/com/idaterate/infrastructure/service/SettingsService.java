package com.idaterate.infrastructure.service;

import com.idaterate.infrastructure.common.Constants;
import com.idaterate.infrastructure.settings.DefaultSettings;
import com.idaterate.infrastructure.settings.Setting;
import com.idaterate.infrastructure.repositories.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Joe Deluca on 15/10/2015.
 */
@Service
public class SettingsService {
    @Autowired
    private SettingRepository settingRepository;

    @Cacheable(Constants.SETTINGS_CACHE)
    public String getSetting(String key) {
        // Find database value
        Setting setting = settingRepository.findOne(key);
        if(setting != null) {
            return setting.getValue();
        }

        // Find default value
        if(DefaultSettings.getDefaultSettings().containsKey(key)) {
            return DefaultSettings.getDefaultSettings().get(key);
        }

        throw new IllegalArgumentException("Invalid setting: " + key);
    }

    @CacheEvict(value=Constants.SETTINGS_CACHE, allEntries=true)
    public void addSetting(String key, String value) {
        Setting setting = new Setting(key, value);
        settingRepository.save(setting);
    }
}
