package com.idaterate.interfaces.controllers;

import com.idaterate.infrastructure.service.SettingsService;
import com.idaterate.infrastructure.settings.Settings;
import com.idaterate.interfaces.dtos.DateRateDTO;
import com.idaterate.interfaces.dtos.DateRateDisplayItemDTO;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idaterate.domain.DateRate;
import com.idaterate.infrastructure.repositories.DateRateRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LandingPageController extends BaseController {
    
    @Autowired
    private DateRateService dateRateService;

	@Autowired
	private SettingsService settingsService;
	
	@RequestMapping("/")
	public String index(Model model) {
	    
	    // Get Date Rates
		List<DateRateDisplayItemDTO> bestDateRateList = new ArrayList<>();
		for(DateRate dateRate : dateRateService.getBestDateRates()) {
			bestDateRateList.add(DateRateDisplayItemDTO.build(dateRate));
		}
	    model.addAttribute("bestDateRateList", bestDateRateList);

		List<DateRateDisplayItemDTO> worstDateRateList = new ArrayList<>();
		for(DateRate dateRate : dateRateService.getWorstDateRates()) {
			worstDateRateList.add(DateRateDisplayItemDTO.build(dateRate));
		}
		model.addAttribute("worstDateRateList", worstDateRateList);
	    
		return "index";
	}
}
