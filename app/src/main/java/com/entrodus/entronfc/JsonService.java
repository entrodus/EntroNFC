package com.entrodus.entronfc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public final class JsonService {

    public static String SerialiseToJson(Object object) {
        final ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static <T> T DeserialiseFromJson(String json, Class<T> tclass){
        final ObjectMapper mapper = new ObjectMapper();
        final T reply;
        try {
            reply = mapper.readValue(json, tclass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return reply;
    }


}
