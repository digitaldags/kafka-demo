package com.kafka.consumer.kafkademo.controller;

import com.kafka.consumer.kafkademo.domain.UserDetails;
import com.kafka.consumer.kafkademo.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KafkaProducerController {
    private final KafkaProducerService service;

    @PostMapping("/send")
    public String send(@RequestBody UserDetails userDetails) {
        try {
            service.sendMessage(userDetails);
            return "Message sent!";
        } catch (Exception e) {
            return "Error sending message: " + e.getMessage();
        }
    }
}
