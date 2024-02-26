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
    public By textRequired = By.xpath("//p[@id='firstname-error']");

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
    public void verifyFirstNameNull(){
        Assert.assertTrue(isDisplayed(textRequired),"Error message NOT display");
        Assert.assertEquals(getElementText(textRequired),"This field is required.","Text of error massage NOT match.");
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
    public void verifyFirstNameInvalid(String firstName,String lastName, String email, String password){
        setText(inputFirstName,firstName);
        setText(inputLastName,lastName);
        setText(inputEmail,email);
        setText(inputPassword,password);
        clickElement(btnSave);
        verifyFirstNameNull();
    }
}
