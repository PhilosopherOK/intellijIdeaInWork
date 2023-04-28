package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();

        final String sensorName = "Sensor123";

        registerSensor(sensorName);

        int maxTemperature = 45;
        for (int i = 0; i < 500; i++) {
            System.out.println(i);
            sendMeasurement(random.nextInt(maxTemperature),
                    random.nextBoolean(), sensorName);
        }
    }

    private static void registerSensor(String sensorName){
        final String url = "http://localhost:8080/sensors/registration";

        Map< String , Object> jsonData = new HashMap<>();
        jsonData.put("name", sensorName);

        makePostRequestWithJSONData(url, jsonData);
    }

    private static void sendMeasurement(double value, boolean raining, String sensorName){
        final String url = "http://localhost:8080/measurements/add";

        Map<String , Object> jsonData = new HashMap<>();
        jsonData.put("value", value);
        jsonData.put("raining", raining);
        jsonData.put("sensor", Map.of("name", sensorName));

        makePostRequestWithJSONData(url, jsonData);
    }

    private static void makePostRequestWithJSONData(String url, Map<String , Object> jsonData){
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(jsonData, httpHeaders);

        try{
            restTemplate.postForObject(url, request, String.class);

            System.out.println("updating successful!");
        }catch (HttpClientErrorException e){
            System.out.println("Error!");
            System.out.println(e.getMessage());
        }

    }
}
