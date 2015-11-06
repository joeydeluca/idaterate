package com.idaterate.interfaces.controllers;

import com.idaterate.infrastructure.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthenticationController extends BaseController {

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletResponse response) {
        AuthenticationService.destroyToken(response);
        return "redirect:/";
    }
}
