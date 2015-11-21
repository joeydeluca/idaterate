package com.idaterate.interfaces.controllers;

import com.idaterate.domain.DateRate.DateRate;
import com.idaterate.interfaces.dtos.DateRateDisplayItemDTO;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Joe Deluca on 07/11/2015.
 */
@Controller
public class ViewDateRateController {

    @Autowired
    DateRateService dateRateService;

    @RequestMapping("/viewdaterate")
    public String viewDateRate(Model model, @RequestParam(required = true) Long id) {
        DateRate dateRate = dateRateService.findOne(id);

        model.addAttribute("dateRate", DateRateDisplayItemDTO.build(dateRate));

        return "viewdaterate";
    }
}
