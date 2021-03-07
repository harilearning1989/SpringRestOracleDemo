package com.example.demo.utils;

import com.google.common.io.Resources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;

public interface IDemoUtils {

    static final Logger LOGGER = LoggerFactory.getLogger(IDemoUtils.class.getName());

    public static String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
    }

    public static String getBytesFromMultipartFile(MultipartFile file) {
        String content = null;
        try {
            content = new String(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static Properties fetchProperties() {
        Properties properties = new Properties();
        try {
            File file = ResourceUtils.getFile("classpath:service-details.properties");
            InputStream in = new FileInputStream(file);
            properties.load(in);
            System.out.println("properties====" + properties);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return properties;
    }

}
