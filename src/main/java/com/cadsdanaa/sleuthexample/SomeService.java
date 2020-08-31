package com.cadsdanaa.sleuthexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeService {

    @Autowired
    RestTemplate restTemplate;

    public String callExternalService() {
        return restTemplate.getForObject("/someOtherThing", String.class);
    }

}
