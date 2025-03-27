package com.Test.PageFactory.stepDefinitions;

import com.Test.PageFactory.utility.PageActions;
import com.Test.PageFactory.utility.Pages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class TestHandles extends PageActions implements Pages {
    static Map<String,String> tabMap = new HashMap<>();

    @Given("^user has opened multiple pages$")
    public void user_has_opened_multiple_pages(DataTable data) {
        bp.navigateToUrl("http://duckduckgo.com");
        for (Map d:data.asMaps()) {
            openNewTab(d.get("search_txt").toString(), d.get("match_txt").toString());
        }
    }
    @When("^user gets a list of handles$")
    public void user_gets_a_list_of_handles() {
        printTabs(getTabNames());
        tabMap = getTabNames();
    }
    @Then("^user navigates from page to page$")
    public void user_navigates_from_page_to_page(DataTable data) {
        // Write code here that turns the phrase above into concrete actions
        for (Map d:data.asMaps()) {
            switchTab(tabMap, d.get("substring").toString());
        }
    }
    @And("^user closes all tabs$")
    public void user_closes_all_tabs(DataTable data) {
        tabMap = getTabNames();
        for (Map d:data.asMaps()) {
            closeTabs(tabMap, d.get("substring").toString());
        }
    }
}
