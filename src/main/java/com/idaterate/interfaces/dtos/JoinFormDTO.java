package com.idaterate.interfaces.dtos;

import com.idaterate.domain.User.IUserRepository;
import com.idaterate.infrastructure.service.CryptographyUtil;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
public class JoinFormDTO {
    private String username;
    private String email;
    private String password;
    private String city;
    private String recaptcha;
    private boolean agreeToEmail;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRecaptcha() {
        return recaptcha;
    }

    public void setRecaptcha(String recaptcha) {
        this.recaptcha = recaptcha;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAgreeToEmail() {
        return agreeToEmail;
    }

    public void setAgreeToEmail(boolean agreeToEmail) {
        this.agreeToEmail = agreeToEmail;
    }

    public IUserRepository.User toUser() throws Exception {
        IUserRepository.User user = new IUserRepository.User();
        user.setEmail(email);
        user.setUsername(username);
        user.setCity(city);
        user.setPassword(CryptographyUtil.toMD5(password));
        return user;
    }
}
