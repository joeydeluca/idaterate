package com.idaterate.interfaces.controllers;

import com.idaterate.infrastructure.repositories.IUserRepository;
import com.idaterate.infrastructure.service.AuthenticationUtil;
import com.idaterate.infrastructure.service.SettingsService;
import com.idaterate.infrastructure.settings.Settings;
import com.idaterate.interfaces.dtos.JoinFormDTO;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationController extends BaseController {
    
    @Autowired
    private IUserRepository userRepository;
    
    @Autowired
    @Qualifier("joinFormValidator")
    private Validator validator;

    @Autowired
    private SettingsService settingsService;
 
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model, HttpServletRequest request) {
        if (!model.containsAttribute("joinFormDTO")) {
            model.addAttribute("joinFormDTO", new JoinFormDTO());
        }

        if(settingsService.getSettingValue(Settings.RECAPTCHA_SITE_KEY) != null &&
                settingsService.getSettingValue(Settings.RECAPTCHA_SECRET_KEY) != null) {
            model.addAttribute("recaptcha_site_key", settingsService.getSettingValue(Settings.RECAPTCHA_SITE_KEY));
        }

        return "join";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String submit(@ModelAttribute("joinFormDTO") @Validated JoinFormDTO joinFormDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attr,
                         HttpServletResponse response) throws Exception {
        if(bindingResult.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.joinFormDTO", bindingResult);
            attr.addFlashAttribute("joinFormDTO", joinFormDTO);
            return "redirect:/registration";
            
        }

        // Ok, Let's sign up!
        userRepository.save(joinFormDTO.toUser());

        // Create token
        AuthenticationUtil.createToken(joinFormDTO.getUsername(), response);

        return "redirect:/joinsuccess";
    }

    @RequestMapping(value = "/joinsuccess", method = RequestMethod.GET)
    public String success() {
        return "joinsuccess";
    }
}
