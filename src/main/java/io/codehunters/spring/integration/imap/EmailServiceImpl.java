package io.codehunters.spring.integration.imap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(fixedDelay = 300000)
    public void send() {
        System.out.println("Send mail");
    }

}
