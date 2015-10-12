package com.idaterate.interfaces.controllers;

import com.idaterate.domain.DateRate;
import com.idaterate.infrastructure.repositories.DateRateRepository;
import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaywallUsernameController {
    
    @Autowired
    private DateRateRepository dateRateRepository;

	@Autowired
	private DateRateService dateRateService;
	
	@RequestMapping("/usernamepaywall")
	public String index(Model model) {
		return "paywall-username";
	}
}
