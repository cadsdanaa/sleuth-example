package com.cadsdanaa.sleuthexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeService {

    private RestTemplate restTemplate;
    private String javaServerUrl;

    public SomeService(RestTemplate restTemplate, @Value("${other-java-server.url}") String javaServerUrl) {
        this.restTemplate = restTemplate;
        this.javaServerUrl = javaServerUrl;
    }

    public String callExternalService() {
        return restTemplate.getForObject(javaServerUrl + "/someOtherEndpoint", String.class);
    }

}
