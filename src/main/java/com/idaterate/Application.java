package com.idaterate;

import com.idaterate.domain.DateRate.DateRate;
import com.idaterate.domain.valueobejcts.DatingSite;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableJpaRepositories
@ComponentScan("com.idaterate")
public class Application implements CommandLineRunner {

    @Autowired
    private Environment environment;

    @Autowired
    private DateRateService dateRateService;

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
                dateRate.setCity("Toronto");
                dateRateService.save(dateRate);
            }
        }
    }
}
