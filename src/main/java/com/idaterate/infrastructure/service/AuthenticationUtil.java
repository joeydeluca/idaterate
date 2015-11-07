package com.idaterate.infrastructure.service;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public class AuthenticationUtil {
    private final static String COOKIE_NAME = "daterateauth";

    public static void createToken(String username, HttpServletResponse response) {
        Cookie cookie = new Cookie(COOKIE_NAME, Base64.encode(username.getBytes()));
        response.addCookie(cookie);
    }

    public static String getToken(HttpServletRequest request) {
        if(request == null || request.getCookies() == null) return null;

        for(Cookie cookie : request.getCookies()) {
            if(COOKIE_NAME.equals(cookie.getName())) {
                if(cookie.getValue() != null && cookie.getValue().length() > 0)
                    try {
                        return new String(Base64.decode(cookie.getValue()));
                    } catch (Base64DecodingException e) {
                        e.printStackTrace();
                        return null;
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
