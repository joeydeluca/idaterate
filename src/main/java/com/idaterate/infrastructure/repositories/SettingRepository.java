package com.idaterate.infrastructure.repositories;

import com.idaterate.infrastructure.settings.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Joe Deluca on 15/10/2015.
 */
public interface SettingRepository extends JpaRepository<Setting, String> {
}
