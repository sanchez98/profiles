package com.sanchez.project.profile.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MockAPIImpl<T> implements MockAPI<T> {

    private final static Logger LOGGER = Logger.getLogger("mock_api");

    @Override
    public T get(String url, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<T> response;
            response = restTemplate.getForEntity(url, responseType);
            return response.getBody();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al ejecutar la petición: " + url);
            LOGGER.log(Level.SEVERE, getStackTrace(e));
        }
        return null;
    }

    @Override
    public T post(String url, Object body, Class<T> responseType) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<T> response;
            response = restTemplate.postForEntity(url, body, responseType);
            return response.getBody();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error al ejecutar la petición: " + url);
            LOGGER.log(Level.SEVERE, getStackTrace(e));
        }
        return null;
    }

    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}
