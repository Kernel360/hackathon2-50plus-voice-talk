package com.example.hackaton250plusvoicetalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Hackaton250plusVoiceTalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hackaton250plusVoiceTalkApplication.class, args);
    }

}
