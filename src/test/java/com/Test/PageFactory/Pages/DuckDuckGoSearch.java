package com.Test.PageFactory.Pages;

import com.Test.PageFactory.utility.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DuckDuckGoSearch {

    private WebDriver driver;

    public DuckDuckGoSearch (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    private JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;

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

    public List<WebElement> getResults () { return resultsList; }
    public List<WebElement> getResultsListLinks() { return resultsListLinks; }

//    public static void clickResult(String text) {
//        getLink(text).click();
//    }
//
//    public void openMultiplePages() {
//        Map<String,String> searchMap = new HashMap<>();
//        searchMap.put("weather", "10-Day Weather Forecast for Bemidji");
//        searchMap.put("health", "WebMD - Better information");
//        searchMap.put("cannabis seeds", "Homegrown Cannabis Co.");
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        for (Map.Entry me:searchMap.entrySet()) {
//            driver.switchTo().window(tabs.get(0));
//            driver.navigate().to("http://www.duckduckgo.com");
//            search(me.getKey().toString());
//            openNewWindow(me.getValue().toString());
//        }
//    }
//
//    public void openNewWindow(String text) {
//        String link = getLinkText(text); // Replace with your desired URL
//        js.executeScript("window.open();");
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabs.size()-1));
//        driver.get(link);
//    }
//
//    private WebElement getLink(String text) {
//        AtomicReference<WebElement> link = new AtomicReference<>();
//        AtomicInteger i = new AtomicInteger();
//        resultsList.forEach(r -> {
//            if (r.getText().contains(text)) {
//                link.set(resultsListLinks.get(i.get()));
//            }
//            i.getAndIncrement();
//        });
//        return link.get();
//    }
//
//    private String getLinkText(String text) {
//        AtomicReference<WebElement> link = new AtomicReference<>();
//        AtomicInteger i = new AtomicInteger();
//        resultsList.forEach(r -> {
//            if (r.getText().contains(text)) {
//                link.set(resultsListLinks.get(i.get()));
//            }
//            i.getAndIncrement();
//        });
//        return link.get().getAttribute("href");
//    }
}
