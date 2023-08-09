package com.kafka.consumer.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerComponent {

    @KafkaListener(topics = "test-12345", groupId = "test-group")
    public void listenGroupFoo(String message) {
        System.out.println(message);
    }
}