package com.assignment.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpUtil {

	@Value("${target.url}")
    private String targetUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public void postToTargetService(Map<String, String> payload) {
        restTemplate.postForEntity(targetUrl, payload, String.class);
    }
}

