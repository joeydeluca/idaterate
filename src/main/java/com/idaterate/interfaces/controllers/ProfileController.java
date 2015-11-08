package com.idaterate.interfaces.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Joe Deluca on 07/11/2015.
 */
@Controller
public class ProfileController extends BaseController {

    @RequestMapping("/editprofile")
    public String showEditProfile() {
        return "editprofile";
    }
}
