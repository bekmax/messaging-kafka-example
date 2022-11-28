package com.example.kafka.com.messaging.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "app",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
