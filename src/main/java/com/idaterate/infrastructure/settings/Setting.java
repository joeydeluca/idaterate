package com.idaterate.infrastructure.settings;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Joe Deluca on 15/10/2015.
 */
@Entity
public class Setting {
    @Id
    private String key;
    private String value;

    public Setting(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private Setting() {}

    public String getValue() {
        return value;
    }
}
