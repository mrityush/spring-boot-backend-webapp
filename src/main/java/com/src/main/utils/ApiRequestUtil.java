package com.src.main.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;

/**
 * Created by intelligrape on 25/2/16.
 */
public class ApiRequestUtil {

    public static HttpHeaders getHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    public static HashMap<String,Object> getRequestBody() {
        HashMap<String, Object> requestBody = new HashMap<String, Object>();
        return requestBody;
    }
}
