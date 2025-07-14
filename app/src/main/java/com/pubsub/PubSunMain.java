package com.pubsub;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PubSunMain implements CommandLineRunner {

    private final PublisherService publisherService;

    public PubSunMain(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PubSunMain.class, args);
    }

    @Override
    public void run(String... args) {
        publisherService.sendEvent("Hello from Publisher!");
    }
}

