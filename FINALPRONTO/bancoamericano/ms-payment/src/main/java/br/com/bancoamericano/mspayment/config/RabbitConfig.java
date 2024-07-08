package br.com.bancoamericano.mspayment.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue pointsQueue() {
        return new Queue("pointsQuere", false);
    }
}

