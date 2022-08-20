package com.dailycodebuffer.websocket.controller;

import com.dailycodebuffer.websocket.model.Template;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Template greet(Template template, Principal principal) {

        return new Template() {{
            setMessage(principal.getName() + ": " + template.getMessage());
        }};
    }
}
