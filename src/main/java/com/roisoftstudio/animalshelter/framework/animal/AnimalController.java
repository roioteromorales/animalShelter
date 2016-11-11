package com.roisoftstudio.animalshelter.framework.animal;

import java.util.concurrent.atomic.AtomicLong;

import com.roisoftstudio.animalshelter.domain.animal.Animal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping("/greeting")
    public Animal greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Animal(counter.incrementAndGet(),
                String.format(template, name));
    }
}