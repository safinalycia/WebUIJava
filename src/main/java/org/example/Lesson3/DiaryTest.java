package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Random;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);


//        driver.get("https://diary.ru");
//        WebElement loginEntry = driver.findElement(By.xpath("//*[@id=\"navbar_user-collapse\"]/ul[1]/li[1]/a"));
//        loginEntry.click();
//
//        WebElement LoginForm = driver.findElement(By.id("loginform-username"));
//        LoginForm.sendKeys("СашевСаша");
//        driver.findElement(By.id("loginform-password")).sendKeys("NdqiGHF0rC");
//
//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
//        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
//        driver.switchTo().parentFrame();
//        driver.findElement(By.xpath("//*[@id=\"login_btn\"]")).click();
//
//        Thread.sleep(5000);
driver.get("https://diary.ru");
        Cookie cookie = new Cookie("_identity_", "2124385bfc2c02e559126f7bd94ee0447be292f590f3d0deb5a5383f0ac08c89a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A54%3A%22%5B%223579722%22%2C%22vpfuwTJYKsvixyiqlHAU3NtM_igiW_Dh%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        //driver.manage().getCookieNamed("_identity_"); удаление куки

        Thread.sleep(5000);

        //создаем новую запись

        driver.findElement(By.id("writeThisDiary")).click();
        String postTitle = "Капча" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("TEST");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

        Thread.sleep(3000);

       //driver.findElement(By.xpath("//a[text()='Капча890']")).click();
       //driver.findElement(By.xpath(String.format("//a[text()='%s']", postTitle))).click();


//находим список всех элементов и среди них последнюю созданную запись
        List<WebElement> postTitles = driver.findElements(By.xpath("//a[@class='title']"));
        postTitles.stream().filter(p ->p.getText().equals(postTitle)).findFirst().get().click();

        Thread.sleep(5000);
        driver.quit();




    }
}
