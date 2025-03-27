package com.Test.PageFactory.utility;

import org.openqa.selenium.WebDriver;


public class BasePage {

    static String browser = System.getProperty("browser");
    public static WebDriver driver = WebDriverManager.getInstance(browser).getDriver();

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

}
