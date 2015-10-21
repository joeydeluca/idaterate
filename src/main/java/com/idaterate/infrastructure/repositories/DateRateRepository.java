package com.idaterate.infrastructure.repositories;

import com.idaterate.domain.DateRate;
import com.idaterate.infrastructure.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Joe Deluca on 03/10/2015.
 */
@Repository
public class DateRateRepository {

    @Autowired
    private IDateRateRepository iDateRateRepository;

    @Cacheable(Constants.DATE_RATE_CACHE)
         public Page<DateRate> findAll(Pageable pageable) {
        return iDateRateRepository.findAll(pageable);
    }

    @Cacheable(Constants.DATE_RATE_CACHE)
    public List<DateRate> findByUsername(String username) {
        return iDateRateRepository.findByDateUsername(username);
    }

    @CacheEvict(value=Constants.DATE_RATE_CACHE, allEntries=true)
    public DateRate save(DateRate entity) {
        return iDateRateRepository.save(entity);
    }

}
