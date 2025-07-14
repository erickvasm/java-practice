package com.pubsub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EventTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private Subscriber subscriber;

    @Test
    void testEventIsReceivedBySubscriber() throws InterruptedException {
        String testMessage = "Hello Event!";
        publisher.publishEvent(new Event(this, testMessage));

        Thread.sleep(100);

        assertEquals(testMessage, subscriber.getLastMessage());
    }
}

