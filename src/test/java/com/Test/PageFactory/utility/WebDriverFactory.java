package com.Test.PageFactory.utility;

import java.time.Duration;

import io.cucumber.java.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    public static WebDriver driver;

    public WebDriverFactory() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        opts.addArguments("--incognito");
        opts.addArguments("--headless");
//        String chromeDriverPath = "/src/test/resources/drivers/chromedriver";
//        if (System.getProperty("os.name").toLowerCase().contains("win")) {
//            chromeDriverPath+=".exe";
//        }
//        System.setProperty("webdriver.chrome.driver",
//                System.getProperty("user.dir") + chromeDriverPath);
        WebDriverManager.chromedriver().setup();
        WebDriverFactory.driver = new ChromeDriver(opts);
        System.out.println(System.getProperty("user.dir"));

        WebDriverFactory.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverFactory.driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

//    @AfterAll
    public void close() {
        driver.quit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
