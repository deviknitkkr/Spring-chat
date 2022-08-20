package com.dailycodebuffer.websocket.controller;

import com.dailycodebuffer.websocket.model.Template;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Template greet(Template template, Principal principal) {

        return new Template() {{
            setMessage(principal.getName() + ": " + template.getMessage());
        }};
    }
}
