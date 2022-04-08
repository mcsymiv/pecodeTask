package com.mcs.pecodetask.utils;

import com.mcs.pecodetask.config.PecodePropsConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class Helper {

    @Autowired
    private WebDriver webDriver;
//    private final WebDriver webDriver;

//    @Autowired
//    public Helper(WebDriver webDriver) {
//        this.webDriver = webDriver;
//    }

    public WebElement waitVisibilityOfElement(
            WebElement element, int timeOfWait, int... timeOfTryOut
    ) {
        WebElement webElement = element;
        int timeOfRevision = timeOfTryOut.length == 0
                ? 100
                : timeOfTryOut[0];
        try {
            webElement = new WebDriverWait(webDriver,
                    timeOfWait,
                    timeOfRevision
            ).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }
}
