package com.idaterate.interfaces.controllers;

import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idaterate.domain.DateRate;
import com.idaterate.infrastructure.repositories.DateRateRepository;

@Controller
public class LandingPageController {
    
    @Autowired
    private DateRateService dateRateService;
	
	@RequestMapping("/")
	public String index(Model model) {
	    
	    // Get Date Rates
	    model.addAttribute("bestDateRateList", dateRateService.getBestDateRates());
		model.addAttribute("worstDateRateList", dateRateService.getWorstDateRates());
	    
		return "index";
	}
}
