package com.onboardly.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onboardly.service.EmailService;

@RestController
@RequestMapping("/api/mail")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailRequest request) {
        try {
            emailService.sendEmail(request.getTo(), request.getSubject(), request.getContent());
            return "Correo enviado correctamente.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al enviar el correo.";
        }
    }

    public static class EmailRequest {
        private String to;
        private String subject;
        private String content;

        // Getters y setters
        public String getTo() { return to; }
        public void setTo(String to) { this.to = to; }

        public String getSubject() { return subject; }
        public void setSubject(String subject) { this.subject = subject; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }
}
