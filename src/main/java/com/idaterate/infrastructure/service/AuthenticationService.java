package com.idaterate.infrastructure.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public class AuthenticationService {
    private final static String COOKIE_NAME = "daterateauth";

    public static void createToken(String username, HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, username);
        response.addCookie(cookie);
    }

    public static String getToken(HttpServletRequest request) {
        for(Cookie cookie : request.getCookies()) {
            if(COOKIE_NAME.equals(cookie.getName())) {
                if(cookie.getValue() != null && cookie.getValue().length() > 0)
                return cookie.getValue();
            }
        }

        return null;
    }

    public static void destroyToken(HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, "");
        response.addCookie(cookie);
    }
}
