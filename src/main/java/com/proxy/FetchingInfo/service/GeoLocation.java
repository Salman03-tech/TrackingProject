package com.proxy.FetchingInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class GeoLocation {

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String,Object> getLocation(String ip){

        String url = "http://ip-api.com/json/" + ip;

        return restTemplate.getForObject(
                url,
                Map.class
        );
    }


}
