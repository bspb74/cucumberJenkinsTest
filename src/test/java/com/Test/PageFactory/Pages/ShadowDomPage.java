package com.Test.PageFactory.Pages;

import com.Test.PageFactory.utility.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShadowDomPage {

    public WebDriver driver;

    public ShadowDomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    private JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.driver;

    public WebElement getElem(String item) {
        WebElement we = (WebElement) js.executeScript("return document.querySelector('body > smart-ui-menu').shadowRoot.querySelector('[aria-label=\"" + item + "\"]')");
        return we;
    }

    public void clickElem(String elem) {
        WebElement we = (WebElement) js.executeScript("return document.querySelector('body > smart-ui-menu').shadowRoot.querySelector('[aria-label=\"" + elem + "\"]')");
        we.click();
    }

    public void enterValue (String value, WebElement we) {
        String jsScript = "arguments[0].setAttribute('value', \"" + value + "\")";
        js.executeScript(jsScript, we);
    }
}
