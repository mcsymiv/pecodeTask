package com.mcs.pecodetask.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Component
@Scope("cucumber-glue")
public class LoginPage {

    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.ID, using = "logomini")
    private WebElement logo;

    @FindBy(how = How.CSS, using = "input[name=\"username\"]")
    private WebElement userNameInput;

    @FindBy(how = How.CSS, using = "input[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(how = How.CSS, using = "[name=\"username\"] ~ [class=\"help-block\"]")
    private WebElement usernameHelpBlock;

    @FindBy(how = How.CSS, using = "[name=\"password\"] ~ [class=\"help-block\"]")
    private WebElement passwordHelpBlock;

    public void inputUserName(String username) {
        userNameInput.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
