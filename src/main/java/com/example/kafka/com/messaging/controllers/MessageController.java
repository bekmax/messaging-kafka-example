package com.example.kafka.com.messaging.controllers;

import com.example.kafka.com.messaging.dto.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, String> template;

    @PostMapping
    public void publish(@RequestBody MessageRequest request){
        template.send("app", request.message());
    }
}
