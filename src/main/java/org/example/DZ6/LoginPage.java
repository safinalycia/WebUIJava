package org.example.DZ6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final String emailIdLocator = "email";

    @FindBy(id = emailIdLocator)
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @Step("Логин")
    public MainPage login(String login, String password) {
        //webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailIdLocator)));
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return new MainPage(driver);
    }

}
