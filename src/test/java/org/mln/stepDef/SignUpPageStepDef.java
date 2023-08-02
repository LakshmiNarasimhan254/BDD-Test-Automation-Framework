package org.mln.stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.Assertions;
import org.mln.customexceptions.CustomException;
import org.mln.pages.automationExercise.SignUpPage;

import java.util.List;
import java.util.Map;

public class SignUpPageStepDef {

    SignUpPage signUpPage = new SignUpPage();

    @Then("^The user should be navigated to Signup Page$")
    public void the_user_should_be_navigated_to_Signup_Page() {
        try {
            Assertions.assertThat(signUpPage.getPageTitle()).isEqualTo("Automation Exercise - Signup");
        } catch (Exception e) {
            throw new CustomException("The Current Page Title : " + signUpPage.getPageTitle() + " is not same as Automation Exercise - Signup." + e.getMessage());
        }
    }

    @When("^The user enters the following (.*) in Signup Page$")
    public void the_user_enters_the_following_in_Signup_Page(String information, DataTable dataTable) {
        try {
            List<Map<String, String>> userDetails = dataTable.asMaps();
            Integer informationRow = Integer.valueOf(information) - 1;
            Map<String, String> userDetail = userDetails.get(informationRow);
            for (String userField : userDetail.keySet()) {
                String userValue = userDetail.get(userField);
                switch (userField) {
                    case "Title":
                        signUpPage.chooseTitle(userValue);
                        break;
                    case "Name":
                        signUpPage.enterName(userValue);
                        break;
                    case "Password":
                        signUpPage.enterPassword(userValue);
                        break;
                    case "Date of Birth":
                        signUpPage.enterDate(userValue);
                        break;
                    case "Sign up for our newsletter!":
                        switch (userValue.toLowerCase().trim()) {
                            case "yes":
                            case "checked":
                            case "true":
                                signUpPage.checkSignUpForNewsLetter();
                                break;
                            default:
                                signUpPage.unCheckSignUpForNewsLetter();
                        }
                        break;
                    case "Receive special offers from our partners!":
                        switch (userValue.toLowerCase().trim()) {
                            case "yes":
                            case "checked":
                            case "true":
                                signUpPage.chkbxReceiveSpecialOffers();
                                break;
                            default:
                                signUpPage.unChkbxReceiveSpecialOffers();
                        }
                    case "First name":
                        signUpPage.enterFirstName(userValue);
                        break;
                    case "Last name":
                        signUpPage.enterLastName(userValue);
                        break;
                    case "Address":
                        signUpPage.enterAddressLine1(userValue);
                        break;
                    case "Address 2":
                        signUpPage.enterAddressLine2(userValue);
                        break;
                    case "Country":
                        signUpPage.selectCountry(userValue);
                        break;
                    case "State":
                        signUpPage.enterState(userValue);
                        break;
                    case "City":
                        signUpPage.enterCity(userValue);
                        break;
                    case "Zipcode":
                        signUpPage.enterZipCode(userValue);
                        break;
                    case "Mobile Number":
                        signUpPage.enterMobileNumber(userValue);
                        break;
                    default:
                        continue;
                }
            }
        } catch (Exception e) {
            throw new CustomException("The value could not be entered in the corresponding field due to: " + e.getMessage());
        }
    }
    @And("^The user clicks on (.*) in Signup Page$")
    public void the_user_clicks_on_in_Signup_Page(String fieldName) {
        try {
            String userInputField = fieldName.toLowerCase().replaceAll(" ", "");
            switch (userInputField) {
                case "createaccount":
                    signUpPage.submitCreateAccount();
                    break;
                default:
                    throw new CustomException("The " + fieldName + " could not be clicked.");
            }
        } catch (Exception e) {
            throw new CustomException("The " + fieldName + " could not be clicked." + e.getMessage());
        }
    }

}

