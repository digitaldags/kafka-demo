package com.kafka.consumer.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerComponent {

    @KafkaListener(id = "theConsumer", topics = "test-12345", groupId = "test-group")
    public void listen(String message) {
        System.out.println(message);
    }
}