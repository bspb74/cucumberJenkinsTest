package com.Test.PageFactory.Pages;

import com.Test.PageFactory.utility.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DuckDuckGoSearch {

    public WebDriver driver;

    public DuckDuckGoSearch (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    private JavascriptExecutor js = (JavascriptExecutor) WebDriverFactory.driver;

    @FindBy(xpath="//*[@aria-label=\"Search with DuckDuckGo\"]")
    private WebElement ddgSearch;

    @FindBy(xpath="//article/div[3]/h2/a/span")
    private List<WebElement> resultsList;

    @FindBy(xpath="//article/div[3]/h2/a")
    private List<WebElement> resultsListLinks;

    public void search(String text) {
        Actions ac = new Actions(driver);
        ac.moveToElement(ddgSearch);
        ac.sendKeys(text);
        ac.sendKeys(Keys.ENTER).build().perform();
    }

    public void clickResult(String text) {
        AtomicReference<WebElement> link = new AtomicReference<>();
        AtomicInteger i = new AtomicInteger();
        resultsList.forEach(r -> {
            if (r.getText().contains(text)) {
                link.set(resultsListLinks.get(i.get()));
            }
            i.getAndIncrement();
        });
        link.get().click();
    }
}
