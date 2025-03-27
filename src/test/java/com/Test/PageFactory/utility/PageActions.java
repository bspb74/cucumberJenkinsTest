package com.Test.PageFactory.utility;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class PageActions implements Pages {

    private WebDriver driver = WebDriverManager.getDriver();

    private JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;

    public void clickResult(String text) {
        getLink(text).click();
        try {
            driver.findElement(By.xpath("//button[@class=\"sailthru-overlay-close\"]")).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void openMultiplePages() {
        Map<String,String> searchMap = new HashMap<>();
        searchMap.put("weather", "10-Day Weather Forecast for Bemidji");
        searchMap.put("health", "WebMD - Better information");
        searchMap.put("cannabis seeds", "Homegrown Cannabis Co.");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (Map.Entry me:searchMap.entrySet()) {
            driver.switchTo().window(tabs.get(0));
            driver.navigate().to("http://www.duckduckgo.com");
            duckDuckGo.search(me.getKey().toString());
            openNewWindow(me.getValue().toString());
        }
    }

    public void openNewTab(String searchTxt, String matchTxt) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(0));
        }
        driver.navigate().to("http://www.duckduckgo.com");
        duckDuckGo.search(searchTxt);
        openNewWindow(matchTxt);
    }

    public void openNewWindow(String text) {
        String link = getLinkText(text); // Replace with your desired URL
        js.executeScript("window.open();");
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
        driver.get(link);
    }

    private WebElement getLink(String text) {
        AtomicReference<WebElement> link = new AtomicReference<>();
        AtomicInteger i = new AtomicInteger();
        duckDuckGo.getResults().forEach(r -> {
            if (r.getText().contains(text)) {
                link.set(duckDuckGo.getResultsListLinks().get(i.get()));
            }
            i.getAndIncrement();
        });
        return link.get();
    }

    private String getLinkText(String text) {
        AtomicReference<WebElement> link = new AtomicReference<>();
        AtomicInteger i = new AtomicInteger();
        duckDuckGo.getResults().forEach(r -> {
            if (r.getText().contains(text)) {
                link.set(duckDuckGo.getResultsListLinks().get(i.get()));
            }
            i.getAndIncrement();
        });
        return link.get().getAttribute("href");
    }

    public Map<String,String> getTabNames() {
        Map<String,String> tabMap = new HashMap<>();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        String tabTitle;
        for (String t:tabs) {
            driver.switchTo().window(t);
            tabTitle = driver.getTitle();
            tabMap.put(tabTitle, t);
        }
        return tabMap;
    }

    public void printTabs(Map<String,String> tabMap) {
        tabMap.forEach((k,v) -> {
            System.out.println("Tab Name: " + k + " => " + v);
        });
    }

    public void switchTab(Map<String,String> handleMap, String srchTxt) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        String windowHandle;
        for (Map.Entry t: handleMap.entrySet()) {
            if (t.getKey().toString().contains(srchTxt)) {
                System.out.println("Key: " + t.getKey().toString());
                windowHandle = t.getValue().toString();
                driver.switchTo().window(windowHandle);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                if (t.getKey().toString().contains("Sandbox")) {
                    closeAlert();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.getMessage();
                    }
                }
                break;
            }
        }
    }

    public void closeTabs(Map<String,String> handleMap, String srchTxt) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        String windowHandle;
        for (Map.Entry t: handleMap.entrySet()) {
            if (t.getKey().toString().contains(srchTxt)) {
                System.out.println("Key: " + t.getKey().toString());
                windowHandle = t.getValue().toString();
                driver.switchTo().window(windowHandle);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
                driver.close();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        }
        driver.switchTo().window(tabs.get(0));
    }

    public void closeAlert() {
        WebElement we = driver.findElement(By
                .xpath("//*[contains(@id, \"-close-icon\") and starts-with(@id, \"popup-widget\")]"));
        we.click();
    }
}
