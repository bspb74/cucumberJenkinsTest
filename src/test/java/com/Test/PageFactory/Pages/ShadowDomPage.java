package com.Test.PageFactory.Pages;

import com.Test.PageFactory.utility.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShadowDomPage {

    private WebDriver driver;

    public ShadowDomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    private JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;

    public List<WebElement> getMenuItems(String selector, String text) {
        List<WebElement> menuItems = (List<WebElement>) js
                .executeScript("return document.querySelector('body > smart-ui-menu').shadowRoot.querySelector('[" +
                        selector + "=\"" + text + "\"]').querySelectorAll('smart-menu-item')");
        return menuItems;
    }
    public WebElement getElem(String selector, String text) {
        WebElement we = (WebElement) js.executeScript("return document.querySelector('body > smart-ui-menu').shadowRoot.querySelector('[" + selector + "=\"" + text + "\"]')");
        return we;
    }

    public void clickElem(String selector, String elem) {
        WebElement we = (WebElement) js.executeScript("return document.querySelector('body > smart-ui-menu').shadowRoot.querySelector('[" + selector + "=\"" + elem + "\"]')");
//        js.executeScript("arguments[0].click();", we);
        we.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void enterValue (String value, WebElement we) {
        String jsScript = "arguments[0].setAttribute('value', \"" + value + "\")";
        js.executeScript(jsScript, we);
    }

    public void findCheckedMenuItems(String selector, String text) {
        List<WebElement> menuItems = getMenuItems(selector, text);
        System.out.println("Number of Elems: " + menuItems.size());
        menuItems.forEach(we -> {
            try {
                if (we.getAttribute("aria-checked").equalsIgnoreCase("true")) {
                    System.out.println(we.getAttribute("aria-label"));
                }
            } catch (NullPointerException e) {
                e.getMessage();
            }
        });
    }
}
