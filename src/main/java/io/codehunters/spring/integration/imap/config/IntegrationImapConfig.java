package io.codehunters.spring.integration.imap.config;

import io.codehunters.spring.integration.imap.config.properties.IntegrationImapProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.mail.dsl.Mail;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Configuration
@EnableConfigurationProperties(IntegrationImapProperties.class)
@EnableScheduling
@EnableIntegration
public class IntegrationImapConfig {

    @Autowired
    private IntegrationImapProperties imapProperties;

    @Bean
    public IntegrationFlow imapIntegrationFlow() throws UnsupportedEncodingException {
        System.out.println(String.format("%s://%s:%s@%s:%s/%s", imapProperties.getProtocol(), URLEncoder.encode(imapProperties.getUsername(), "UTF-8"), imapProperties.getPassword(), imapProperties.getHost(), imapProperties.getPort(), imapProperties.getFolder()));
        return IntegrationFlows
                .from(Mail.imapInboundAdapter(String.format("%s://%s:%s@%s:%s/%s", imapProperties.getProtocol(), URLEncoder.encode(imapProperties.getUsername(), "UTF-8"), imapProperties.getPassword(), imapProperties.getHost(), imapProperties.getPort(), imapProperties.getFolder()))
                        , e -> e.autoStartup(true)
                                .poller(p -> p.fixedDelay(1000)))
                .channel(MessageChannels.queue("imapChannel"))
                .log()
                .get();


    }

/*

/*
    @Bean
    public IntegrationFlow imapIntegrationFlow() throws UnsupportedEncodingException, MessagingException {

        String user = URLEncoder.encode("andres.montoya.codehuntersio@gmail.com", "UTF-8");
        String password = URLEncoder.encode("**$4nDr3s**", "UTF-8");
        return IntegrationFlows
                .from(Mail.imapInboundAdapter("imaps://" + user + ":" + password + "@imap.gmail.com:993/inbox")
                                .userFlag("testSIUserFlag")
                                .shouldMarkMessagesAsRead(true)
                                .shouldDeleteMessages(false)
                                //.javaMailProperties()
                        , e -> e.autoStartup(true)
                                .poller(p -> p.fixedDelay(1000)))
                .channel("receiveChannel")
                .transform(new MessageProcessor() {
                    @Override
                    public Object processMessage(Message message) {
                        System.out.println(message);
                        return null;
                    }
                })
                .log()
                .get();
    }*/

}
