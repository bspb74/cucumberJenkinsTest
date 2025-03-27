package com.Test.PageFactory.utility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverManager {

    private static volatile WebDriverManager instance;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private WebDriverManager() {}

    private void initDriver(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--remote-allow-origins=*");
                opts.addArguments("--incognito");
                opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                boolean headless = (System.getProperty("headless") != null);
                if (headless) {
                    opts.addArguments("--headless");
                }
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver()
                        .cachePath(System.getProperty("user.dir") + "/src/test/java/com/Test/PageFactory/resources/drivers")
                        .avoidOutputTree().setup();
                driver.set(new ChromeDriver(opts));
                break;
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(System.getProperty("headless") != null);
                options.addArguments("-private");
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver()
                        .cachePath(System.getProperty("user.dir") + "/src/test/java/com/Test/PageFactory/resources/drivers")
                        .avoidOutputTree().setup();
                driver.set(new FirefoxDriver(options));
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

    }

    public static WebDriverManager getInstance(String browser) { // not synchronized
        if (instance == null) {
            synchronized (WebDriverManager.class) {
                if (instance == null) {
                    instance = new WebDriverManager();
                }
            }
        }
        if (driver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    public static WebDriver getDriver() {
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().manage().window().maximize();
        return driver.get();
    }

    public static void quitBrowser() {
        System.out.println("Closing Browser - Start");
        if (driver.get() != null) {
            System.out.println("Browser not Null -> Closing!");
            driver.get().quit();
            driver.remove();
        }
    }
}
