package com.mcs.pecodetask;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootTest
@ComponentScan
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
public class CucumberSpringConfiguration {
}
