package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {
    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//button[@class='btn logout']")
    WebElement lcTabLogout;
    @FindBy (xpath = "//label[normalize-space()='Your Name :']")
           WebElement lcYourNameText;
    @FindBy (xpath = "//button[normalize-space()='Logout']")
           WebElement lcTabLogoutByXpath;
    @FindBy (xpath = "//button[normalize-space()='Transactions']")
           WebElement lcTabTransactions;
    @FindBy (xpath = "//button[normalize-space()='Deposit']")
           WebElement lcTabDeposit;
    @FindBy (xpath = "//button[normalize-space()='Withdrawl']")
           WebElement lcTabWithdrawl;
    @FindBy (xpath = "//input[@placeholder='amount']")
          WebElement  lcAmountInputBox;
    @FindBy (xpath = "//button[normalize-space()='Deposit']")
           WebElement lcButtonDeposit;
    @FindBy (xpath = "//span[@class='error ng-binding' and contains(text(),'Deposit Successful')]")
           WebElement lcMessageDepositSuccess;
    @FindBy (xpath = "input[placeholder='amount']")
           WebElement lcAmountWithdrawlInputBoxByCss;
    @FindBy (xpath = "button[type='submit']")
           WebElement lcButtonWithdrawalByCss;
    @FindBy (xpath = "//span[@class='error ng-binding']")
           WebElement lcMessageWithdrawalSuccessByXpath;

    public void verifyLogoutButtonDisplay(){
        isDisplayed(lcTabLogout);
    }
    public void clickOnLogoutButton(){
        clickOnElement(lcTabLogout);
        CustomListeners.test.log(Status.PASS,"logout Button");
    }
    public void verifyYourNameIsDisplayed(){
        isDisplayed(lcYourNameText);
        CustomListeners.test.log(Status.PASS,"Name Is Display");
    }
    public void clickOnDepositeButton(){
        clickOnElement(lcButtonDeposit);
        CustomListeners.test.log(Status.PASS,"Click On Deposite Button");
    }
    public void enterAmountYouWantToDeposit(String text){
        sendTextToElement(lcAmountInputBox,text);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + text);

    }
    public String actualSuccessMsg(){

        String message = getTextFromElement(lcMessageWithdrawalSuccessByXpath);
        CustomListeners.test.log(Status.PASS,"Get welcomeText");
        return message;
    }

}
