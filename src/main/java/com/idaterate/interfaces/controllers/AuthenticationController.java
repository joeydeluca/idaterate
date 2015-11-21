package com.idaterate.interfaces.controllers;

import com.idaterate.domain.User.IUserRepository;
import com.idaterate.infrastructure.service.AuthenticationUtil;
import com.idaterate.interfaces.dtos.LoginFormDTO;
import com.idaterate.service.AuthenticationService;
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

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class AuthenticationController extends BaseController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    @Qualifier("loginFormValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute("loginFormDTO") @Validated LoginFormDTO loginFormDTO,
                        BindingResult bindingResult,
                        HttpServletResponse response) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if(bindingResult.hasErrors()) {
            return "login";
        }

        IUserRepository.User user = authenticationService.login(loginFormDTO.getEmail(), loginFormDTO.getPassword());
        if(user == null) {
            model.addAttribute("error", "No user found for Email and Password!");
            return "login";
        }

        // User is valid, log them in!
        AuthenticationUtil.createToken(user.getUsername(), response);

        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletResponse response) {
        AuthenticationUtil.destroyToken(response);
        return "redirect:/";
    }
}
