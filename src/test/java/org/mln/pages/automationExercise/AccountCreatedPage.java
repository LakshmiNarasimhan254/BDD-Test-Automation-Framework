package org.mln.pages.automationExercise;

import org.mln.enums.WaitConditions;
import org.mln.pages.BasePage;
import org.mln.utils.DynamicXPathUtil;
import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage {
    // A dynamic xpath.
    private By txtAccountCreated = By.xpath("//b[contains(text(),'Account')]");
      private By btnContinue =By.xpath("//a[contains(text(),'Continue')]");
    public String getTxtAccountCreatedText() {
        return seleniumInteractionsUtil.getElementText( txtAccountCreated,WaitConditions.VISIBLE,"Account Created Text");

    }


    public void clickContinue(){
        seleniumInteractionsUtil.click(btnContinue,WaitConditions.CLICKABLE,"Continue Button");
    }
}
