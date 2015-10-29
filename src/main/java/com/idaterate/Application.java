package com.idaterate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.idaterate.domain.DateRate;
import com.idaterate.domain.DatingSite;
import com.idaterate.infrastructure.settings.Settings;
import com.idaterate.infrastructure.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.idaterate.infrastructure.repositories.DateRateRepository;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableCaching
//@PropertySource("classpath:application.properties")
@ComponentScan("com.idaterate")
public class Application implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Autowired
    private DateRateRepository dateRateRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        if(Arrays.asList(environment.getActiveProfiles()).contains("dev")) {
            for (int i = 0; i < 10; i++) {
                DateRate dateRate = new DateRate();
                dateRate.setDateUsername("test username " + i);
                dateRate.setDescription("The best I ever had");
                dateRate.setScore(i);
                dateRate.setDatingSite(DatingSite.MATCH.getId());
                List<String> tags = new ArrayList<String>();
                tags.add("#cool");
                tags.add("#niceguy");
                dateRate.setHashtags(tags);
                dateRateRepository.save(dateRate);
            }
        }
    }
}
