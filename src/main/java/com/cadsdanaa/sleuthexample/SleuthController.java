package com.cadsdanaa.sleuthexample;

import brave.Tracer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class SleuthController {

    private final Tracer tracer;
    private final SomeService someService;

    @GetMapping("/something")
    public String doSomething() {
        String currentTraceId = tracer.currentSpan().context().traceIdString();
        String externalTraceId = someService.callExternalService();
        return "My Trace Id: " + currentTraceId + " --- Trace Id in app running on different port: " + externalTraceId;
    }

    @GetMapping("/someOtherThing")
    public String doSomethingElse() {
        String currentTraceId = tracer.currentSpan().context().traceIdString();
        log.info("My Trace Id: {}", currentTraceId);
        return currentTraceId;
    }

}
