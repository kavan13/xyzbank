package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends TestBase {
    HomePage homePage;
    AccountPage accountPage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;

@BeforeMethod(alwaysRun = true)
    public void inIt(){
     homePage=new HomePage();
     accountPage= new AccountPage();
     addCustomerPage=new AddCustomerPage();
     bankManagerLoginPage=new BankManagerLoginPage();
     openAccountPage=new OpenAccountPage();
     customerLoginPage=new CustomerLoginPage();
     customersPage=new CustomersPage();


}
    @Test (groups = {"smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        homePage.clickOnBankManagerLoginButton();
        homePage.clickOnAddCustomerButton();
        addCustomerPage.enterYourFirstName("Kavan");
        addCustomerPage.enterYourLastName("Patel");
        addCustomerPage.enterYourPostalCode("Ha8 7Lp");

        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertEquals(homePage.actualTextFromPopUp(),homePage.expectedTextFromPopUp("Customer added successfully with customer id :6"),"Popup message not matched");
        homePage.clickonOkfromPopup();

    }

    @Test (groups = {"sanity","regression"})
    public void bankManagerShouldOpenAccountSuccessfully(){
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage.clickonOpenAccountPage();

        openAccountPage.selectCustomerName("1");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        Assert.assertEquals(homePage.actualTextFromPopUp(),homePage.expectedTextFromPopUp("Account created successfully with account Number :1016"),"Popup message not matched");
        homePage.clickonOkfromPopup();
    }
    @Test (groups = {"regression1","regression"})
    public void customerShouldLoginAndLogoutSuceessfully(){
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName(1);
        customerLoginPage.clickOnLoginButton();
        customersPage.verifyLogoutButtonDisplay();
        customersPage.clickOnLogoutButton();
        customersPage.verifyYourNameIsDisplayed();

    }
    @Test (groups = {"smoke","sanity","regression"})
    public void customerShouldDepositMoneySuccessfully(){
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName(1);
        customerLoginPage.clickOnLoginButton();
        customersPage.clickOnDepositeButton();
        customersPage.enterAmountYouWantToDeposit("100");
//    String actualmsg=customersPage.actualSuccessMsg();
//    String expectedmsg="Deposit Successful";
//    Assert.assertEquals(expectedmsg,actualmsg,"invalid click");


    }
    @Test (groups = {"smoke","sanity","regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLogin();
        customerLoginPage.selectYourName(1);
        Thread.sleep(1000);
        accountPage.clickOnLoginButton();
        Thread.sleep(1000);
        openAccountPage.clickOnWithdraw();
        openAccountPage.sendWithdrawAmount("50");
        openAccountPage.clickOnWithdrawTabButton();
        String expectedText = "Transaction successful";
        String actualText = openAccountPage.verifyMoneyWithdrawSuccessfullyMessage();
        Assert.assertEquals(actualText,expectedText);

    }




}
