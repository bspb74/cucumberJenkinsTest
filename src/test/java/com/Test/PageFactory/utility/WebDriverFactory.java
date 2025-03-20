package com.Test.PageFactory.utility;

import java.time.Duration;

import io.cucumber.java.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    public static WebDriver driver;
    String browser = "firefox";
    public WebDriverFactory() {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions opts = new ChromeOptions();
            opts.addArguments("--remote-allow-origins=*");
            opts.addArguments("--incognito");
            opts.addArguments("--headless");
            WebDriverManager.chromedriver()
                    .cachePath(System.getProperty("user.dir") + "/src/test/java/com/Test/PageFactory/resources/drivers")
                    .avoidOutputTree().setup();
            WebDriverFactory.driver = new ChromeDriver(opts);
            System.out.println(System.getProperty("user.dir"));
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(false);
            options.addArguments("-private");
            WebDriverManager.firefoxdriver()
                    .cachePath(System.getProperty("user.dir") + "/src/test/java/com/Test/PageFactory/resources/drivers")
                    .avoidOutputTree().setup();
            WebDriverFactory.driver = new FirefoxDriver(options);
        }
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
