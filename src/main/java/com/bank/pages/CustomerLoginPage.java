package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends Utility {
    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "userSelect")
    WebElement lcDropDownYourName;
    @FindBy (xpath = "//button[contains(text(),'Login')]")
           WebElement lcButtonLogin;
    @FindBy (xpath = "//label[normalize-space()='Your Name :']")
           WebElement lcLabelYourName;

    public void selectYourName(int value) {
        selectByIndexFromDropDown(lcDropDownYourName,value);
        CustomListeners.test.log(Status.PASS," Select Name" + value);
    }

    public void clickOnLoginButton() {
        clickOnElement(lcButtonLogin);
        CustomListeners.test.log(Status.PASS,"loginButton");

    }
}
