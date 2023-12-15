package com.WebSocketWithKafkaTest3.GGG;
// KafkaConsumerService.java
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String TOPIC = "chat-test100";

    private final SimpMessagingTemplate messagingTemplate;

    public KafkaConsumerService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println("Consumed message from Kafka: " + message);
        messagingTemplate.convertAndSend("/topic/chat", message);
    }
}
