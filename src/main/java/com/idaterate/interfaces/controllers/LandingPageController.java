package com.idaterate.interfaces.controllers;

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
    private DateRateRepository dateRateRepository;
	
	@RequestMapping("/")
	public String index(Model model) {
	    
	    // Get Date Rates
	    Page<DateRate> dateRatePage = dateRateRepository.findAll(new PageRequest(0, 10));
	    model.addAttribute("dateRateList", dateRatePage.getContent());
	    
		return "index";
	}
}
