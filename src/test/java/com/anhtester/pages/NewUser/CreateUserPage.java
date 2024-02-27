package com.anhtester.pages.NewUser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.anhtester.keywords.ActionKeywords.*;

public class CreateUserPage {
    public By btnStaff = By.xpath("//a[@href='https://crm.anhtester.com/admin/staff']");
    public By btnNewStaffMember = By.xpath("//a[normalize-space()='New Staff Member']");
    public By inputFirstName = By.xpath("//input[@id='firstname']");
    public By inputLastName = By.xpath("//input[@id='lastname']");
    public By inputEmail = By.xpath("//input[@id='email']");
    public By inputPhone = By.xpath("//input[@id='phonenumber']");
    public By selectLanguage = By.xpath("//select[@id='default_language']");
    public By inputLanguage = By.xpath("//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']");
    public By chooseLanguage = By.xpath("");
    public By inputPassword = By.xpath("//input[@name='password']");
    public By checkboxSendMail = By.xpath("");
    public By btnSave = By.xpath("//button[normalize-space()='Save']");
    public By textRequiredFirstName = By.xpath("//p[@id='firstname-error']");
    public By textRequiredLastName = By.xpath("//p[@id='lastname-error']");
    public By textRequiredEmail = By.xpath("//p[@id='email-error']");
    public By textRequiredEmailInvalid = By.xpath("//p[@id='email-error']");
    public By textRequiredPasswordInvalid = By.xpath("//p[@id='password-error']");

    public void clickMenuStaff(){
        clickElement(btnStaff);
    }
    public void clickNewStaffMember(){
        clickElement(btnNewStaffMember);
    }
    public void verifyStaffPage(){
        Assert.assertTrue(getCurrentUrl("/staff"), "FAIL. Not must page Staff");
    }
//    public void selectedItem(By locator, String text) {
//        Select select = new Select(getWebElement(locator));
//        select.selectByVisibleText(text);
//    }
    public void verifyFirstNameInvalid(){
        Assert.assertTrue(isDisplayed(textRequiredFirstName),"Error message NOT display");
        Assert.assertEquals(getElementText(textRequiredFirstName),"This field is required.","Text of error massage NOT match.");
    }
    public void verifylastNameInvalid(){
        Assert.assertTrue(isDisplayed(textRequiredLastName),"Error message NOT display");
        Assert.assertEquals(getElementText(textRequiredLastName),"This field is required.","Text of error massage NOT match.");
    }
    public void verifyEmaillNull(){
        Assert.assertTrue(isDisplayed(textRequiredEmail),"Error message NOT display");
        Assert.assertEquals(getElementText(textRequiredEmail),"This field is required.","Text of error massage NOT match.");
    }
    public void verifyEmaillInvalid(){
        Assert.assertTrue(isDisplayed(textRequiredEmailInvalid),"Error message NOT display");
        Assert.assertEquals(getElementText(textRequiredEmailInvalid),"Please enter a valid email address.","Text of error massage NOT match.");
    }
    public void verifyPasswordInvalid(){
        Assert.assertTrue(isDisplayed(textRequiredPasswordInvalid),"Error message NOT display");
        Assert.assertEquals(getElementText(textRequiredPasswordInvalid),"This field is required.","Text of error massage NOT match.");
    }
    public void insertInfomtionUser(String firstName, String lastName, String email, String phone, String password, String language){
        setText(inputFirstName,firstName);
        setText(inputLastName,lastName);
        setText(inputEmail,email);
        setText(inputPhone,phone);
        selectedItem(selectLanguage,language);
        setText(inputPassword,password);
        clickElement(btnSave);
    }
    public void verifyInvalid(String firstName,String lastName, String email, String password){
        setText(inputFirstName,firstName);
        setText(inputLastName,lastName);
        setText(inputEmail,email);
        setText(inputPassword,password);
        clickElement(btnSave);
    }
}
