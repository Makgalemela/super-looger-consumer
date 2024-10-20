package com.example.Engine.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class PublishMessage {
    private static final Logger logger = LoggerFactory.getLogger(PublishMessage.class);

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public PublishMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Bean
    public void publishMessage2() {

       Map<String, Object> message = new HashMap<>();
       message.put("data", "STAGE_1");
       String exchange = "host.2.host.test.config";
       String routingKey = "routing.key.host.2.host.test.config";
       rabbitTemplate.convertAndSend(exchange, routingKey, message);
       logger.info("Message published: " + message);
    }
}
