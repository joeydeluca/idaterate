package com.idaterate.interfaces.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController extends BaseController {
	
	@RequestMapping("/contact")
	public String index(Model model) {
		return "contact";
	}
}
