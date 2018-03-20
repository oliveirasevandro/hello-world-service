package com.evandro.oliveira.hello.world.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}

@RestController
class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World") String name) throws InterruptedException {

        long millis = (long) (Math.random() * 10) * 1000;

        Thread.sleep(millis);

        LOGGER.info("Request took " + millis + " millisenconds to respond");

        return "Hello, " + name;
    }

}
