package com.Test.PageFactory.Pages;

import com.Test.PageFactory.utility.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearch {

    private WebDriver driver;

    public GoogleSearch (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    private JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;

    public WebElement getShadowInputElem(String selector) {
        WebElement we = (WebElement) js
                .executeScript("return document.querySelector(\"body > ntp-app\").shadowRoot.querySelector(\"" +
                        selector + "\").shadowRoot.querySelector(\"#input\")");
        return we;
    }

    public void googleSearch(String selector, String text) {
        Actions ac = new Actions(driver);
        ac.moveToElement(getShadowInputElem(selector));
        ac.sendKeys(text);
        ac.sendKeys(Keys.ENTER).build().perform();
    }

    public void googleSearch(String text) {
        Actions ac = new Actions(driver);
        ac.moveToElement(searchBox);
        ac.sendKeys(text);
        ac.sendKeys(Keys.ENTER).build().perform();
    }

    @FindBy(xpath="//span[contains(text(),\"Results for\")]/following-sibling::span[2]")
    private WebElement results;

    @FindBy(xpath="//*[@aria-label=\"Search\"]")
    private WebElement searchBox;

    public String getResults() {
        return results.getText();
    }

}
