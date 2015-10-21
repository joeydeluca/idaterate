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
    public String search(@RequestParam(value="username") String username, Model model) {
        List<DateRateDisplayItemDTO> bestDateRateList = new ArrayList<>();
        for(DateRate dateRate : service.findDateRateByUsername(username)) {
            bestDateRateList.add(DateRateDisplayItemDTO.build(dateRate));
        }
        model.addAttribute("dateRateList", bestDateRateList);
        return "search";
    }

}
