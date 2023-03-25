package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Consumer {
    public static void main( String[] args ) {
        Random random = new Random();
        RestTemplate restTemplate = new RestTemplate();


        Map<String, String> jsonToSend = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Integer randomValue = random.nextInt(100);
            Boolean randomRaining = random.nextBoolean();
            jsonToSend.put("value", "25");
            jsonToSend.put("raining", "true");
            jsonToSend.put("sensor", "animal");
        }

        HttpEntity<Map<String ,String>> request = new HttpEntity<>(jsonToSend);


        String urlPost = "http://localhost:8080/measurements/add";
        String responsePost = restTemplate.postForObject(urlPost, request, String.class);
        System.out.println(responsePost);


//
//        String urlGet = "http://localhost:8080/measurements";
//        String responseGet = restTemplate.getForObject(urlGet, String.class);
//        System.out.println(responseGet);

    }
}
