package com.mcs.pecodetask.steps;

import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

@Slf4j
public class MainPageSteps {

    @Then("^I see Main page$")
    public void iSeeMainPage() {
        log.info("I see Main page");
        // fail is intentional
        Assert.fail();
    }
}
