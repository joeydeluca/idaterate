package com.idaterate.infrastructure.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public class AuthenticationUtil {
    private final static String COOKIE_NAME = "daterateauth";

    public static void createToken(String username, HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, Base64.getEncoder().encodeToString(username.getBytes()));
        response.addCookie(cookie);
    }

    public static String getToken(HttpServletRequest request) {
        if(request == null || request.getCookies() == null) return null;

        for(Cookie cookie : request.getCookies()) {
            if(COOKIE_NAME.equals(cookie.getName())) {
                if(cookie.getValue() != null && cookie.getValue().length() > 0) {
                    return new String(Base64.getDecoder().decode(cookie.getValue()));
                }
            }
        }

        return null;
    }

    public static void destroyToken(HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, "");
        response.addCookie(cookie);
    }
}
