package com.idaterate.infrastructure.service;

import com.idaterate.infrastructure.common.Constants;
import com.idaterate.infrastructure.repositories.ISettingRepository;
import com.idaterate.infrastructure.settings.Setting;
import com.idaterate.infrastructure.settings.Settings;
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
    private ISettingRepository settingRepository;

    @Cacheable(Constants.SETTINGS_CACHE)
    public String getSettingValue(Settings settingEnum) {
        // Find database value first
        Setting setting = settingRepository.findOne(settingEnum.getKey());
        if(setting != null) {
            return setting.getValue();
        }

        // Otherwise, use default value
        return settingEnum.getDefaultValue();
    }

    @CacheEvict(value=Constants.SETTINGS_CACHE, allEntries=true)
    public void addSetting(Settings settingsEnum, String value) {
        Setting setting = new Setting(settingsEnum.getKey(), value);
        settingRepository.save(setting);
    }
}
