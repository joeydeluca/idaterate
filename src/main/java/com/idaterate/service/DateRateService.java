package com.idaterate.service;

import com.idaterate.domain.DateRate;
import com.idaterate.infrastructure.repositories.DateRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Joe Deluca on 06/10/2015.
 */
@Service
public class DateRateService {

    @Autowired
    DateRateRepository dateRateRepository;

    public List<DateRate> getBestDateRates() {
        PageRequest request = new PageRequest(0, 5, Sort.Direction.DESC, "score");
        return dateRateRepository.findAll(request).getContent();
    }

    public List<DateRate> getWorstDateRates() {
        PageRequest request = new PageRequest(0, 5, Sort.Direction.ASC, "score");
        return dateRateRepository.findAll(request).getContent();
    }

    public List<DateRate> findDateRateByUsername(String username) {
        return dateRateRepository.findByUsername(username);
    }

}
