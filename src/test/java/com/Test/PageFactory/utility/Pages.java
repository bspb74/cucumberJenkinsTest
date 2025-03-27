package com.Test.PageFactory.utility;

import com.Test.PageFactory.Pages.DuckDuckGoSearch;
import com.Test.PageFactory.Pages.GoogleSearch;
import com.Test.PageFactory.Pages.LoginPage;
import com.Test.PageFactory.Pages.ShadowDomPage;
import org.openqa.selenium.WebDriver;

public interface Pages {

    WebDriver drvr = WebDriverManager.getDriver();
    BasePage bp = new BasePage();
    LoginPage loginPage = new LoginPage(drvr);
    ShadowDomPage shadowPage = new ShadowDomPage(drvr);
    GoogleSearch gs = new GoogleSearch(drvr);
    DuckDuckGoSearch duckDuckGo = new DuckDuckGoSearch(drvr);
}
