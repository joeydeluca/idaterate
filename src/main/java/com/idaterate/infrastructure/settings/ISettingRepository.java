package com.idaterate.infrastructure.settings;

import com.idaterate.infrastructure.settings.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joe Deluca on 15/10/2015.
 */
public interface ISettingRepository extends JpaRepository<Setting, String> {
}
