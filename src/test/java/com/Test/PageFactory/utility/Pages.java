package com.Test.PageFactory.utility;

import com.Test.PageFactory.Pages.DuckDuckGoSearch;
import com.Test.PageFactory.Pages.GoogleSearch;
import com.Test.PageFactory.Pages.LoginPage;
import com.Test.PageFactory.Pages.ShadowDomPage;

public interface Pages {

    WebDriverFactory wd = new WebDriverFactory();
    LoginPage lp = new LoginPage(WebDriverFactory.driver);
    ShadowDomPage sp = new ShadowDomPage(WebDriverFactory.driver);
    GoogleSearch gs = new GoogleSearch(WebDriverFactory.driver);
    DuckDuckGoSearch dds = new DuckDuckGoSearch(WebDriverFactory.driver);
}
