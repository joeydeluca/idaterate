package com.idaterate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig
{
    @Autowired
    Environment env;

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    @Profile("prod")
    public DataSource dataSourceProd() {
        String databaseUrl = env.getProperty("database.url");
        String databaseUsername = env.getProperty("database.username");
        String databasePassword = env.getProperty("database.password");

        if(System.getenv("IDR_DATABASE_URL") != null) databaseUrl = System.getenv("IDR_DATABASE_URL");
        if(System.getenv("IDR_DATABASE_USERNAME") != null) databaseUsername = System.getenv("IDR_DATABASE_USERNAME");
        if(System.getenv("IDR_DATABASE_PASSWORD") != null) databasePassword = System.getenv("IDR_DATABASE_PASSWORD");

        return DataSourceBuilder.create()
                .url(databaseUrl)
                .username(databaseUsername)
                .password(databasePassword)
                .build();
    }

}