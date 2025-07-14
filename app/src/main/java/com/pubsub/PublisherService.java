package com.pubsub;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    private final ApplicationEventPublisher publisher;

    public PublisherService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void sendEvent(String message) {
        publisher.publishEvent(new Event(this, message));
    }
}

