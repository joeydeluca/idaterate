package com.idaterate.service;

import com.idaterate.domain.User;
import com.idaterate.infrastructure.repositories.IUserRepository;
import com.idaterate.infrastructure.service.CryptographyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Joe Deluca on 05/11/2015.
 */
@Component
public class AuthenticationService {

    @Autowired
    IUserRepository userRepository;

    public User login(String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(CryptographyUtil.toMD5(password))) {
            return user;
        }

        return null;
    }
    
}
