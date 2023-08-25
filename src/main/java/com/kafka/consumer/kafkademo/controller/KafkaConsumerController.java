package com.kafka.consumer.kafkademo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.config.KafkaListenerEndpoint;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class KafkaConsumerController {
    private final KafkaListenerEndpointRegistry endpointRegistry;

    @PostMapping("/start-consumer")
    public String startConsumer(@RequestParam String consumerId) {
        MessageListenerContainer endpoint = endpointRegistry.getListenerContainer(consumerId);

        if (endpoint != null) {
            endpoint.start();
            return "Consumer started successfully!";
        } else {
            return "Consumer not found.";
        }
    }

    @PostMapping("/stop-consumer")
    public String stopConsumer(@RequestParam String consumerId) {
        MessageListenerContainer endpoint = endpointRegistry.getListenerContainer(consumerId);

        if (endpoint != null) {
            endpoint.stop();
            return "Consumer stopped successfully!";
        } else {
            return "Consumer not found.";
        }
    }
}
