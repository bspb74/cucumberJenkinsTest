package com.Test.PageFactory.Pages;

import com.Test.PageFactory.utility.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginBtn;

    public void verifyLogin(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
    }
    public void entersUsername(String uname) {
        username.sendKeys(uname);
    }
    public void entersPassword(String pwd) {
        password.sendKeys(pwd);
    }
    public void clicksLogin() {
        loginBtn.click();
    }

    public void verifyPageTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

}
