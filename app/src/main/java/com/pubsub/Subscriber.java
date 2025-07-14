package com.pubsub;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    private String lastMessage;

    @EventListener
    public void handleMyEvent(Event event) {
        System.out.println("Subscriber received: " + event.getMessage());
        this.lastMessage = event.getMessage();
    }

    public String getLastMessage() {
        return lastMessage;
    }
}

