package com.mcs.pecodetask.steps;

import com.mcs.pecodetask.config.PecodePropsConfig;
import com.mcs.pecodetask.pages.LoginPage;
import com.mcs.pecodetask.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

@Slf4j
public class LoginPageSteps {

    @Autowired
    private Helper helper;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private PecodePropsConfig props;

    @When("^I fill in the username$")
    public void iFillInTheUsername() {
        log.info("I fill in the username");
        loginPage.inputUserName(props.getUsername());
    }

    @And("^I fill in the password$")
    public void iFillInThePassword() {
        log.info("I fill in the password");
        loginPage.inputPassword(props.getPassword());
    }

    @And("^I click on Login Button$")
    public void iClickOnLoginButton() {
        log.info("I click on Login Button");
        loginPage.clickLoginButton();
    }

    @Then("^I see password \"(.*)\" error message$")
    public void iSeePasswordErrorMessage(String errorMessage) {
        log.info("I see password {} error message", errorMessage);
        helper.waitVisibilityOfElement(loginPage.getPasswordHelpBlock(), props.getTimewait());
        Assert.assertEquals(
                loginPage.getPasswordHelpBlock().getText(),
                errorMessage,
                "Invalid error message in password help block"
        );
    }

    @Then("^I see username \"(.*)\" error message$")
    public void iSeeUsernameErrorMessage(String errorMessage) {
        log.info("I see username {} error message", errorMessage);
        WebElement usernameHelperBlock = helper.waitVisibilityOfElement(
                loginPage.getUsernameHelpBlock(),
                props.getTimewait());

        Assert.assertEquals(
                usernameHelperBlock.getText(),
                errorMessage,
                "Invalid error message in password help block"
        );
    }
}
