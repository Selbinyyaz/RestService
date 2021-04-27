package com.example.restservice;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GreetingController {
	private static final String template = "Welcome %s!";
    String timestamp = ZonedDateTime.now( ZoneOffset.UTC ).format(DateTimeFormatter.ISO_INSTANT);

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "to the machine") String name) {
        return new Greeting(String.format(template, name),timestamp);
    }

}
