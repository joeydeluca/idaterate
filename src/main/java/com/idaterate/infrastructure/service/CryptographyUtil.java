package com.idaterate.infrastructure.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Joe Deluca on 07/11/2015.
 */
public class CryptographyUtil {
    public static String toMD5(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return new String(md.digest(plainText.getBytes("UTF-8")), "UTF-8");
    }
}
