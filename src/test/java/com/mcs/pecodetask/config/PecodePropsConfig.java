package com.mcs.pecodetask.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "pecode")
public class PecodePropsConfig {

    private String url;
    private long timeout;
    private String username;
    private String password;
    private String imagetype;
    private String imagename;
    private int timewait;
    private String browser;


}
