package com.Test.PageFactory.stepDefinitions;

import com.Test.PageFactory.utility.Pages;
import com.Test.PageFactory.utility.Screenshot;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestLoginPage implements Pages {

//    @Before
//    public void setupScenario(Scenario scenario) {
//        Screenshot.scenario = scenario;
//    }

    @Given("user at login page")
    public void user_at_login_page() {
        bp.navigateToUrl("http://saucedemo.com");
    }
    @When("user enters username")
    public void user_enters_username() {
        loginPage.entersUsername("standard_user");
    }
    @When("user enters password")
    public void user_enters_password() {
        loginPage.entersPassword("secret_sauce");
    }
    @When("user clicks login button")
    public void user_clicks_login() {
        loginPage.clicksLogin();
    }
    @Then("user is directed to homepage")
    public void user_is_directed_to_homepage() {
        loginPage.verifyPageTitle("Swag Labs");
    }
}
