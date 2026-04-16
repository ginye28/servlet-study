package com.example.servletstudy.login;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class JsonParserUtil {

    public static String getJson(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = request.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = BufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    public static Map<String, Object> parse(String json) throws JsonMappingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Map.class);
    }
}
