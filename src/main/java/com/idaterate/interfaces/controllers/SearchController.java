package com.idaterate.interfaces.controllers;

import com.idaterate.domain.DateRate;
import com.idaterate.interfaces.dtos.DateRateDisplayItemDTO;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe Deluca on 06/10/2015.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private DateRateService service;

    @RequestMapping(method = RequestMethod.GET)
    public String search(@RequestParam(value="username", required = false) String username, Model model) {
        List<DateRateDisplayItemDTO> dateRateList = new ArrayList<>();
        List<DateRate> dateRates = new ArrayList<>();

        if(username != null) {
            dateRates = service.findDateRateByUsername(username);
        } else {
            dateRates = service.getWorstDateRates();
        }

        for (DateRate dateRate : dateRates) {
            dateRateList.add(DateRateDisplayItemDTO.build(dateRate));
        }
        model.addAttribute("dateRateList", dateRateList);
        return "search";
    }

}
