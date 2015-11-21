package com.idaterate.service;

import com.idaterate.domain.DateRate.DateRate;
import com.idaterate.domain.DateRate.IDateRateRepository;
import com.idaterate.domain.valueobejcts.SortingOption;
import com.idaterate.infrastructure.common.Constants;
import com.idaterate.domain.DateRate.DateRateSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Joe Deluca on 06/10/2015.
 */
@Service
public class DateRateService {

    @Autowired
    IDateRateRepository dateRateRepository;

    @Cacheable(value = Constants.DATE_RATE_CACHE, key = "#root.methodName")
    public List<DateRate> getBestDateRates() {
        PageRequest request = new PageRequest(0, 5, Sort.Direction.DESC, "score");
        List<DateRate> dateRates = new ArrayList<>(dateRateRepository.findAll(request).getContent());
        Collections.shuffle(dateRates);
        return dateRates;
    }

    @Cacheable(value = Constants.DATE_RATE_CACHE, key = "#root.methodName")
    public List<DateRate> getWorstDateRates() {
        PageRequest request = new PageRequest(0, 5, Sort.Direction.ASC, "score");
        List<DateRate> dateRates = new ArrayList<>(dateRateRepository.findAll(request).getContent());
        Collections.shuffle(dateRates);
        return dateRates;
    }

    @Cacheable(Constants.DATE_RATE_CACHE)
    public DateRate findOne(long id) {
        return dateRateRepository.findOne(id);
    }

    @Cacheable(Constants.DATE_RATE_CACHE)
    public Page<DateRate> search(String username, String datingSiteId, String hashtags, String city, SortingOption sortingOption, int page) {
        int pageSize = 5;

        PageRequest request;
        if(SortingOption.BEST_DATES.equals(sortingOption)) {
            request = new PageRequest(page, pageSize, Sort.Direction.DESC, "score");
        }
        else if(SortingOption.WORST_DATES.equals(sortingOption)) {
            request = new PageRequest(page, pageSize, Sort.Direction.ASC, "score");
        } else {
            request = new PageRequest(page, pageSize, Sort.Direction.DESC, "createdDate");
        }

        List<Specification<DateRate>> specifications = new ArrayList<>();
        if(username != null && username.length() > 0) {
            specifications.add((DateRateSpecification.hasUsername(username)));
        }
        if(datingSiteId != null && datingSiteId.length() > 0) {
            specifications.add((DateRateSpecification.hasDatingSite(datingSiteId)));
        }
        if(hashtags != null && hashtags.length() > 0) {
            specifications.add((DateRateSpecification.hasHashtags(hashtags)));
        }
        if(city != null && city.length() > 0) {
            specifications.add((DateRateSpecification.hasCity(city)));
        }

        if(specifications.size() > 0) {
            Specification<DateRate> result = specifications.get(0);
            for (int i = 1; i < specifications.size(); i++) {
                result = Specifications.where(result).and(specifications.get(i));
            }

            return dateRateRepository.findAll(result, request);
        }

        return dateRateRepository.findAll(request);
    }

    @CacheEvict(value=Constants.DATE_RATE_CACHE, allEntries=true)
    public DateRate save(DateRate entity) {
        return dateRateRepository.save(entity);
    }

}
