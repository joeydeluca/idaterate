package com.idaterate.interfaces.controllers;

import com.idaterate.infrastructure.service.AuthenticationUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public class BaseController {

    @ModelAttribute("authenticatedUsername")
    public String getAuthenticatedUsername(HttpServletRequest request) {
        return AuthenticationUtil.getToken(request);
    }

}
