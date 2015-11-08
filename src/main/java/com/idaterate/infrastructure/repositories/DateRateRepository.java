package com.idaterate.infrastructure.repositories;

import com.idaterate.domain.DateRate;
import com.idaterate.infrastructure.common.Constants;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Joe Deluca on 03/10/2015.
 */
@Repository
public class DateRateRepository {

    @PersistenceContext
    private EntityManager entityManager;

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

    @Cacheable(Constants.DATE_RATE_CACHE)
    public Page<DateRate> findAll(Specification specification, Pageable pageable) {
        return iDateRateRepository.findAll(specification, pageable);
    }

    @Cacheable(Constants.DATE_RATE_CACHE)
    public DateRate findOne(long id) {
        return iDateRateRepository.findOne(id);
    }

}
