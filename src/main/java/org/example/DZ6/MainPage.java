package org.example.DZ6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
        mainMenuBlock = new MainMenuBlock(driver);
    }

    public MainMenuBlock mainMenuBlock;

    @Step("Клик на кнопку логина")
    public LoginPage clickSingInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }

}
