package com.idaterate.interfaces.controllers;

import com.idaterate.infrastructure.service.SettingsService;
import com.idaterate.infrastructure.settings.Settings;
import com.idaterate.interfaces.dtos.DateRateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idaterate.domain.DateRate;
import com.idaterate.domain.DatingScore;
import com.idaterate.domain.DatingSite;
import com.idaterate.infrastructure.repositories.DateRateRepository;

@Controller
@RequestMapping("/daterate")
public class AddDateRateController extends BaseController {
    
    @Autowired
    private DateRateRepository dateRateRepository;
    
    @Autowired
    @Qualifier("dateRateValidator")
    private Validator validator;

    @Autowired
    private SettingsService settingsService;
 
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String addDateRate(Model model) {
        if (!model.containsAttribute("dateRateDTO")) {
            model.addAttribute("dateRateDTO", new DateRateDTO());
        }
        model.addAttribute("datingSiteOptions", DatingSite.getValues());
        model.addAttribute("scoreOptions", DatingScore.getDisplayNames());

        DateRateDTO dateRateDTO = (DateRateDTO) model.asMap().get("dateRateDTO");
        model.addAttribute("showPredefinedDatingSiteOther", DatingSite.OTHER.getId().equals(dateRateDTO.getPredefinedDatingSite()));

        if(settingsService.getSettingValue(Settings.RECAPTCHA_SITE_KEY) != null &&
                settingsService.getSettingValue(Settings.RECAPTCHA_SECRET_KEY) != null) {
            model.addAttribute("recaptcha_site_key", settingsService.getSettingValue(Settings.RECAPTCHA_SITE_KEY));
        }

        return "adddaterate";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("dateRateDTO") @Validated DateRateDTO dateRate, BindingResult bindingResult, RedirectAttributes attr) {
        if(bindingResult.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.dateRateDTO", bindingResult);
            attr.addFlashAttribute("dateRateDTO", dateRate);
            return "redirect:/daterate";
            
        }
        
        dateRateRepository.save(dateRate.toDateRate());
        return "adddateratesuccess";
    }
}
