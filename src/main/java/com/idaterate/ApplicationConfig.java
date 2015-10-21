package com.idaterate;

import com.idaterate.infrastructure.common.Constants;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class ApplicationConfig 
{
    @Bean
    public MessageSource messageSource() {
         ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
         messageSource.setBasename("/I18/message");
         messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(Constants.DATE_RATE_CACHE, Constants.SETTINGS_CACHE);
    }



}