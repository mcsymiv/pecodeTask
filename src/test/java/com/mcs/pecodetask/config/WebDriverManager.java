package com.mcs.pecodetask.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class WebDriverManager {

    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String OPERA = "opera";
    private static final String SAFARI = "safari";

    @Autowired
    private PecodePropsConfig props;

    @Bean
    @Scope("cucumber-glue")
//    @ConditionalOnProperty(
//            value = "pecode.browser",
//            havingValue = "chrome")
    public WebDriver webDriverFactory() {
        if (props.getBrowser().equalsIgnoreCase(CHROME)) {
            return new ChromeDriver();

        } else if (props.getBrowser().equalsIgnoreCase(FIREFOX)) {
            return new FirefoxDriver();

        } else if (props.getBrowser().equalsIgnoreCase(OPERA)) {
            return new OperaDriver();

        } else {
            return new SafariDriver();
        }
    }
}
