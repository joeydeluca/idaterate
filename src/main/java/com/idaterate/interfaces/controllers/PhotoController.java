package com.idaterate.interfaces.controllers;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

/**
 * Created by Joe Deluca on 07/11/2015.
 */
@Controller
public class PhotoController {

    @RequestMapping(value = "/photo", produces = "image/jpg", method = RequestMethod.GET)
    @ResponseBody
    public byte[] getPhoto(HttpServletRequest request) throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URI uri = classLoader.getResource("static/images/no_image.jpg").toURI();
        File file = new File(uri);

        return FileUtils.readFileToByteArray(file);
    }
}
