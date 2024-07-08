package com.example.emp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.emp.service.EmailService;

@RestController
@RequestMapping("/emailapi")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

 @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("text") String text,
            @RequestParam("file") MultipartFile file) {

        logger.info("Received request to send email to: {}, Subject: {}", to, subject);

        try {
            emailService.sendEmailWithAttachment(to, subject, text, file);
            logger.info("Email sent successfully to: {}", to);
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to send email to: {}, Error: {}", to, e.getMessage(), e);
            return new ResponseEntity<>("Failed to send email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
