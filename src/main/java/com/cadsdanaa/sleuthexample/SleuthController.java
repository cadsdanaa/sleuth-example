package com.cadsdanaa.sleuthexample;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class SleuthController {

    private final Tracer tracer;
    private final SomeService someService;
    private final RestTemplate restTemplate;
    private final String goServerUrl;

    public SleuthController(Tracer tracer, SomeService someService, RestTemplate restTemplate, @Value("${other-go-server.url}") String goServerUrl) {
        this.tracer = tracer;
        this.someService = someService;
        this.restTemplate = restTemplate;
        this.goServerUrl = goServerUrl;
    }

    @GetMapping("/something")
    public String doSomething() {
        String currentTraceId = tracer.currentSpan().context().traceIdString();
        String externalTraceId = someService.callExternalService();
        return "My Trace Id: " + currentTraceId + " --- Trace Id from downstream apps: " + externalTraceId;
    }

    @GetMapping("/someOtherThing")
    public String doSomethingElse() {
        String currentTraceId = tracer.currentSpan().context().traceIdString();
        log.info("My Trace Id: {}", currentTraceId);
        String goResponse = restTemplate.getForObject(goServerUrl + "/goThing", String.class);
        log.info("Trace Id from Go service: {}", goResponse);
        return currentTraceId + " --- Trace Id in Go app running on different port: " + goResponse;
    }

}
