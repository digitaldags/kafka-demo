package com.kafka.consumer.kafkademo.service;

import com.kafka.consumer.kafkademo.domain.UserDetails;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, UserDetails> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, UserDetails> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserDetails message) {
        kafkaTemplate.send("test-12345", message);
    }
}
