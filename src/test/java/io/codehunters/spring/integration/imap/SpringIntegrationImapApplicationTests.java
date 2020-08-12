package io.codehunters.spring.integration.imap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class SpringIntegrationImapApplicationTests {

    @Autowired
    private JavaMailSender emailSender;

    @Test
    void contextLoads() {

    }

}
