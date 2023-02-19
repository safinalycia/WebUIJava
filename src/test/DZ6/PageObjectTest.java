package org.example.DZ6;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.ByteArrayInputStream;

import static org.openqa.selenium.OutputType.BYTES;


@Story("Добавление в корзину")

public class PageObjectTest {
    WebDriver driver;

  //  @RegisterExtension
   // TestExtention watcher = new TestExtention();

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new AdditionalLogger()).decorate(new ChromeDriver());
       driver.get("http://automationpractice.com/index.php");
   }

    @Test
    @Feature("Корзина")
    @TmsLink("123")
    @DisplayName("Добавить рубашку в корзину")
    void putTShirtToCartTest() throws InterruptedException {
        // MainPage mainPage = new MainPage(driver);
        // mainPage.clickSingInButton();
        // new LoginPage(driver).login("spartalex93@test.test", "123456");
        // new MainMenuBlock(driver).hoverWomenButton();
        // new WomenSuggestPage(driver).

        //new MainPage(driver).clickSingInButton();
        new MainPage(driver).clickSingInButton()
                .login("spartalex93@test.test", "123456")
                .mainMenuBlock.hoverWomenButton()
                .clickTShirtsButton()
                .selectSize("S")
                .moveMouseToProductAndAddToCart()
                .checkTotalSumma("$18.51");
    }

    @AfterEach
    void killBrowser() {
        watcher.setScreenStream(new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(BYTES)));

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());
        }

        driver.quit();
    }

}
