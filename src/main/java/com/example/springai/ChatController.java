package com.example.springai;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/cat-jokes")
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a cat joke") String message){
        return chatClient.call(message);
    }
}
