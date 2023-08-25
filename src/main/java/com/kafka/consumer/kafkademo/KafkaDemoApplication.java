package com.kafka.consumer.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;

@SpringBootApplication
public class KafkaDemoApplication {
    @Autowired
    private KafkaListenerEndpointRegistry endpointRegistry;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Bean
    public ApplicationListener<ContextRefreshedEvent> onApplicationStart() {
        return event -> {
            stopConsumerOnStartup();
        };
    }

    private void stopConsumerOnStartup() {
        MessageListenerContainer endpoint = endpointRegistry.getListenerContainer("theConsumer");

        if (endpoint != null) {
            endpoint.stop();
            System.out.println("Consumer stopped on application startup.");
        } else {
            System.out.println("Consumer not found.");
        }
    }

}
