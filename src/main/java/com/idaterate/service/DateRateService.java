package com.idaterate.service;

import com.idaterate.domain.DateRate;
import com.idaterate.domain.DatingSite;
import com.idaterate.domain.SortingOption;
import com.idaterate.infrastructure.common.Constants;
import com.idaterate.infrastructure.repositories.DateRateRepository;
import com.idaterate.infrastructure.specifications.DateRateSpecification;
import org.springframework.beans.factory.annotation.Autowired;
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
    DateRateRepository dateRateRepository;

    public List<DateRate> getBestDateRates() {
        PageRequest request = new PageRequest(0, 25, Sort.Direction.DESC, "score");
        List<DateRate> dateRates = new ArrayList<>(dateRateRepository.findAll(request).getContent());
        Collections.shuffle(dateRates);
        if(dateRates.size() > 10) {
            dateRates = dateRates.subList(0, 10);
        }
        return dateRates;
    }

    public List<DateRate> getWorstDateRates() {
        PageRequest request = new PageRequest(0, 25, Sort.Direction.ASC, "score");
        List<DateRate> dateRates = new ArrayList<>(dateRateRepository.findAll(request).getContent());
        Collections.shuffle(dateRates);
        if(dateRates.size() > 10) {
            dateRates = dateRates.subList(0, 10);
        }
        return dateRates;
    }

    public List<DateRate> findDateRateByUsername(String username) {
        return dateRateRepository.findByUsername(username);
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

}
