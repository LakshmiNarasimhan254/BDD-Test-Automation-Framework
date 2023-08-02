package org.mln.stepDef;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.mln.customexceptions.CustomException;
import org.mln.pages.automationExercise.HomePage;


public class HomePageStepDef {
    HomePage homePage = new HomePage();



    @Given("^The user is in Home Page$")
    public void the_user_is_in_home_page() {
        try {
            Assertions.assertThat(homePage.getPageTitle()).isEqualTo("Automation Exercise");
        } catch (Exception e) {
            throw new CustomException("The Current Page Title : " + homePage.getPageTitle() + " is not same as Automation Exercise." + e.getMessage());
        }
    }
    @Then("^The user should be navigated to Home Page$")
    public void the_user_should_be_navigated_to_home_page() {
        try {
            Assertions.assertThat(homePage.getPageTitle()).isEqualTo("Automation Exercise");
        } catch (Exception e) {
            throw new CustomException("The Current Page Title : " + homePage.getPageTitle() + " is not same as Automation Exercise." + e.getMessage());
        }
    }
    @When("^The user clicks on  (.*) in Home Page$")
    public void the_user_clicks_on_in_home_page(String fieldName){
        try{
            String userInputField= fieldName.toLowerCase().replaceAll(" ","");
            switch(userInputField) {
                case "signup/login":
                    homePage.clickSignUpLogin();
                    break;
                case "deleteaccount":
                    homePage.clickDeleteAccount();
                    break;
                default:
                    throw new CustomException("The " + fieldName + " could not be clicked.");
            }
        }catch (Exception e){
            throw new CustomException("The " + fieldName + " could not be clicked." + e.getMessage());
        }
    }
    @Then("^Logged in as (.*) should be visible in Home Page$")
    public void logged_in_as_username_should_be_visible_in__home_page(String fieldName){
        try {
            Assertions.assertThat(homePage.getLoggedInUser()).isEqualTo(fieldName);
        } catch (Exception e) {
            throw new CustomException("The Current Logged user : " + homePage.getLoggedInUser() + " is not same as " + fieldName + e.getMessage());
        }
    }

}
