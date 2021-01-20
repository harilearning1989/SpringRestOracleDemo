package com.example.demo.utils;

import com.google.common.io.Resources;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.charset.Charset;

public interface IDemoUtils {
    public static String readResource(final String fileName, Charset charset) throws IOException {
        return Resources.toString(Resources.getResource(fileName), charset);
    }

    public static String getBytesFromMultipartFile(MultipartFile file) {
        String content = null;
        try {
            content  = new String(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
