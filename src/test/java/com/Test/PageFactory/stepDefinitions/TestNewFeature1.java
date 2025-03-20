package com.Test.PageFactory.stepDefinitions;

import com.Test.PageFactory.utility.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestNewFeature1 implements Pages {

    @Given("user is at Google Search Page")
    public void user_is_at_google_search_page() {
        wd.navigateToUrl("http://duckduckgo.com");
    }
    @When("^user searches for (.*)$")
    public void user_searches_for_search_text(String search_text) {
        dds.search(search_text);
    }
    @Then("^select results for (.*)$")
    public void results_are_printed_to_the_screen(String rsltText) {
        dds.clickResult(rsltText);
    }
    @And("user returns to search page")
    public void user_returns_to_search_page() {
        wd.navigateToUrl("http://duckduckgo.com");
    }
}
