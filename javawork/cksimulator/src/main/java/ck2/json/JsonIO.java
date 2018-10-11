package ck2.json;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ck2.bean.Inference;

public class JsonIO {

    private static final String DATE_FORMAT = "y.M.d";
    private static final String SAVES_JSON = "saves.json";

    private static ObjectMapper objectMapper;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(simpleDateFormat);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
    }

    public static String toJson(Object obj) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static Inference fromJson() {
        URL savesJsonURL = JsonIO.class.getClassLoader().getResource(SAVES_JSON);
        Inference inference = null;
        try {
            inference = objectMapper.readValue(savesJsonURL, Inference.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inference;
    }

    public static void main(String[] args) {
        Inference inference1 = null;
        try {
            inference1 = objectMapper.readValue(JsonIO.toJson(JsonIO.fromJson()), Inference.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Inference inference2 = JsonIO.fromJson();
        System.out.println(JsonIO.toJson(inference1).equals(JsonIO.toJson(inference2)));
        System.out.println(JsonIO.toJson(inference1));
    }

}
