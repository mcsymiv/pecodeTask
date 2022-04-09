package com.mcs.pecodetask.steps;


import com.mcs.pecodetask.CucumberSpringConfiguration;
import com.mcs.pecodetask.config.PecodePropsConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@Slf4j
@CucumberContextConfiguration
@SpringBootTest(classes = {CucumberSpringConfiguration.class})
public class Hooks {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private PecodePropsConfig props;

    @Before
    public void openBrowser(Scenario scenario) {
        log.info("====== START: {} ======", scenario.getName());
        webDriver.manage().timeouts().implicitlyWait(props.getTimeout(), TimeUnit.SECONDS);
        webDriver.get(props.getUrl());
    }

    @After
    public void closeBrowser(Scenario scenario) {
        log.info("====== END: {} ======", scenario.getName());
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, props.getImagetype(), props.getImagename());
        }
        webDriver.quit();
    }
}
