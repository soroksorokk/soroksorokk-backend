package com.soroksorokk.soroksorokk.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "jwt")
@Component
public class PropertyConfiguration {
    private String secret;
    private long validateTimeMS;
}
