package com.idaterate.infrastructure.settings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Joe Deluca on 15/10/2015.
 */
@Entity
public class Setting {
    @Id
    private String settingKey;
    private String settingValue;

    public Setting(String key, String value) {
        this.settingKey = key;
        this.settingValue = value;
    }

    private Setting() {}

    public String getValue() {
        return settingValue;
    }
}
