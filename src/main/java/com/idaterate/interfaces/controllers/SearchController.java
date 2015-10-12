package com.idaterate.interfaces.controllers;

import com.idaterate.service.DateRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("dateRateList", service.findDateRateByUsername(username));
        return "search";
    }

}
