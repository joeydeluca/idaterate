package com.idaterate.interfaces.controllers;

import com.idaterate.infrastructure.repositories.DateRateRepository;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IPNListenerController {
    
    @Autowired
    private DateRateRepository dateRateRepository;

	@Autowired
	private DateRateService dateRateService;
	
	@RequestMapping("/ipn")
	public String index(Model model) {
		return "paywall-username";
	}
}
