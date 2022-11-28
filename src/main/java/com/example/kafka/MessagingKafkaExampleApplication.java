package com.example.kafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class MessagingKafkaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingKafkaExampleApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, String> template){
        return args -> {
            for (int i = 0; i < 10; i++) {
                template.send("app", "Hello Kafka "+i+" times");
            }
        };
    }

}
