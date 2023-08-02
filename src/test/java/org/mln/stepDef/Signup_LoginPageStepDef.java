package org.mln.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.mln.customexceptions.CustomException;
import org.mln.pages.automationExercise.SignUp_LoginPage;

public class Signup_LoginPageStepDef {
    SignUp_LoginPage signUp_loginPage = new SignUp_LoginPage();

    @Then("^The user should be navigated to Signup / Login Page$")
    public void the_user_should_be_navigated_to_Signup_Login_Page() {
        try {
            Assertions.assertThat(signUp_loginPage.getPageTitle()).isEqualTo("Automation Exercise - Signup / Login");
        } catch (Exception e) {
            throw new CustomException("The Current Page Title : " + signUp_loginPage.getPageTitle() + " is not same as Automation Exercise - Signup / Login." + e.getMessage());
        }
    }
    @When("^The user enters the (.*) and (.*) in Signup / Login Page$")
    public void the_user_enters_in_Signup_Login_Page(String name ,String emailAddress){
        try{
            signUp_loginPage.enterName(name);
            signUp_loginPage.enterEmail(emailAddress);

        }catch (Exception e){
            throw new CustomException(name +" and " +emailAddress + "could not be entered in Name and Email Address. " +e.getMessage());        }

    }

    @And("^The user clicks on (.*) in Signup / Login Page$")
    public void the_user_clicks_on_in_Signup_Login_Page(String fieldName) {
        try {
            String userInputField = fieldName.toLowerCase().replaceAll(" ", "");
            switch (userInputField) {
                case "signup":
                    signUp_loginPage.clickSignUp();
                    break;
                default:
                    throw new CustomException("The " + fieldName + " could not be clicked.");
            }
        } catch (Exception e) {
            throw new CustomException("The " + fieldName + " could not be clicked." + e.getMessage());
        }
    }

}
