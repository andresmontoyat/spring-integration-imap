package io.codehunters.spring.integration.imap.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "integration.imap")
public class IntegrationImapProperties {

    private static final String DEFAULT_IMAP_PROTOCOL = "imaps";
    private static final String DEFAULT_IMAP_HOST = "localhost";
    private static final int DEFAULT_IMAP_HOST_PORT = 993;
    private static final String DEFAULT_IMAP_FOLDER = "inbox";

    private String protocol = DEFAULT_IMAP_PROTOCOL;

    private String username;

    private String password;

    private String host = DEFAULT_IMAP_HOST;

    private int port = DEFAULT_IMAP_HOST_PORT;

    private String folder = DEFAULT_IMAP_FOLDER;
}