package org.mln.stepDef;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.mln.customexceptions.CustomException;
import org.mln.pages.automationExercise.AccountCreatedPage;

public class AccountCreatedPageStepDef {
    AccountCreatedPage accountCreatedPage =new AccountCreatedPage();

    @Then("^The user should be navigated to Account Created Page$")
    public void the_user_should_be_navigated_to_Signup_Page() {
        try {
            Assertions.assertThat(accountCreatedPage.getPageTitle()).isEqualTo("Automation Exercise - Account Created");
        } catch (Exception e) {
            throw new CustomException("The Current Page Title : " + accountCreatedPage.getPageTitle() + " is not same as Automation Exercise - Signup." + e.getMessage());
        }
    }
    @Then("^(.*) should be visible in Account Created Page$")
    public void value_should_be_visible_in_Account_Create_Page(String userValue){
        try{
            Assertions.assertThat(accountCreatedPage.getTxtAccountCreatedText()).isEqualTo(userValue);
        }catch (Exception e) {
            throw new CustomException("The Current value could not be validate" + e.getMessage());
        }
    }
    @When("^The user clicks on (.*) in Account Created Page$")
    public void the_user_clicks_on_in_Account_Created_Page(String fieldName){
        try {
            String userInputField = fieldName.toLowerCase().replaceAll(" ", "");
            switch (userInputField) {
                case "continue":
                    accountCreatedPage.clickContinue();
                    break;
                default:
                    throw new CustomException("The " + fieldName + " could not be clicked.");
            }
        } catch (Exception e) {
            throw new CustomException("The " + fieldName + " could not be clicked." + e.getMessage());
        }
    }

}

