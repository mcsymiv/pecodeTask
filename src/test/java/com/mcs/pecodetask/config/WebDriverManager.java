package com.mcs.pecodetask.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class WebDriverManager {

    @Bean
    @Scope("cucumber-glue")
    @ConditionalOnProperty(
            value = "pecode.browser",
            havingValue = "chrome")
    public WebDriver webDriverFactory() {
        return new ChromeDriver();
    }
}
