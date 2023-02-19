package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://afisha.ru");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


      // WebElement city = (WebElement) driver.findElement(By.xpath("//*[@id=\"content\"]/header/div[1]/div[1]/div/div/div/div/div"));
      // driver.findElement(By.xpath("//*[@id=\"content\"]/header/div[1]/div[1]/div/div/div/div/div/div[2]/button[2]"));
//city.click();
//Thread.sleep(3000);
        WebElement search = driver.findElement(By.xpath("//*[@id=\"content\"]/header/div[1]/div[2]/form/div/input"));
        search.sendKeys("Шерлок Холмс");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Шерлок Холмс']")));
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Шерлок Холмс']"))));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='Шерлок Холмс']"));
        search.click();


    }
}
