package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class MailService {

    public static final String EMAIL = "artyukhindaniil@yandex.ru";
    private final JavaMailSender emailSender;

    @Autowired
    public MailService(JavaMailSenderImpl emailSender) {
        this.emailSender = emailSender;
    }

    @Async
    public void sendMail(Object o) throws MailException {
        System.out.println("Prepare to send mail");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(EMAIL);
        mail.setTo(EMAIL);
        mail.setSubject("Save new " + o.getClass().getSimpleName() + " at " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .format(LocalDateTime.now()));
        mail.setText(o.toString());
        emailSender.send(mail);
        System.out.println("Email sent!");
    }

}
