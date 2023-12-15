package com.WebSocketWithKafkaTest3.GGG;
// KafkaConsumerController.java
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class KafkaConsumerController {

    @MessageMapping("/send/message")
    @SendTo("/topic/chat")
    public String sendMessage(String message) {
        return message;
    }
}
