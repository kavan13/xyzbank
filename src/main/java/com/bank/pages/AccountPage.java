package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.bank.drivermanager.ManagerDriver.driver;

public class AccountPage extends Utility {
    public AccountPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//label[contains(text(),'Customer :')]")
    WebElement lcCustomerLabel;
    @FindBy (xpath = "//select[@id='userSelect']")
           WebElement lcDropDownCustomer;
    @FindBy (xpath = "//select[@id='currency']")
           WebElement lcDropDownCurrency;
    @FindBy (xpath = "//button[contains(text(),'Process')]")
           WebElement lcButtonProcess;

    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement searchCustomer1;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement loginbutton;


   public void selectCustomeFromDropDown(int value){
       selectByIndexFromDropDown(searchCustomer1,value );
       CustomListeners.test.log(Status.PASS," SelectCustomeFromDropDown" + value);

   }

public void clickOnLoginButton(){
       clickOnElement(loginbutton);
   CustomListeners.test.log(Status.PASS,"loginButton");

}

}
