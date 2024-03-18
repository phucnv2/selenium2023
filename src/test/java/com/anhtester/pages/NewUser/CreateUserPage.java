package com.anhtester.pages.NewUser;

import com.anhtester.helpers.ExcelHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static com.anhtester.helpers.SystemHelper.*;
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
    public By tabPermissions = By.xpath("//a[normalize-space()='Permissions']");
    public By rolePermissions = By.xpath("//select[@id='role']");
    public By btnSave = By.xpath("//button[normalize-space()='Save']");
    public By textRequiredFirstName = By.xpath("//p[@id='firstname-error']");
    public By textRequiredLastName = By.xpath("//p[@id='lastname-error']");
    public By textRequiredEmail = By.xpath("//p[@id='email-error']");
    public By textRequiredEmailInvalid = By.xpath("//p[@id='email-error']");
    public By textRequiredPasswordInvalid = By.xpath("//p[@id='password-error']");
    public By textMessageSuccesss = By.xpath("//span[contains(text(),'Staff Member added successfully.')]");
    public By divFileUpload = By.xpath("//span[contains(text(),'Staff Member added successfully.')]");
    public By inputFileUpload = By.xpath("//input[@id='profile_image']");

    public void clickMenuStaff(){
        clickElement(btnStaff);
    }
    public void clickNewStaffMember(){
        clickElement(btnNewStaffMember);
    }
    public void verifyStaffPage(){
        Assert.assertTrue(getCurrentUrl("/staff"), "FAIL. Not must page Staff");
    }
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
    public void verifyCreateUserSuccess(){
        Assert.assertTrue(isDisplayed(textMessageSuccesss),"Success message NOT display");
        Assert.assertEquals(getElementText(textMessageSuccesss),"Staff Member added successfully.","Text of error massage NOT match.");
    }

    public void upload(){
        uploadFile(inputFileUpload,getCurrentDir() + "src/test/resources/picture/profile_contact.png");
    }

    public void insertInfomtionUser(String firstName, String lastName, String email, String phone, String password, String language){
        upload();
        setText(inputFirstName,firstName);
        setText(inputLastName,lastName);
        setText(inputEmail,email);
        setText(inputPhone,phone);
        selectedItem(selectLanguage,language);
        setText(inputPassword,password);
        clickElement(tabPermissions);
        selectedItem(selectLanguage,language);
        clickElement(btnSave);
    }
    public void insertInfomtionUser_1(String firstName, String lastName, String email, String phone, String password, String language, String role){
        upload();
        setText(inputFirstName,firstName);
        setText(inputLastName,lastName);
        setText(inputEmail,email);
        setText(inputPhone,phone);
        selectedItem(selectLanguage,language);
        setText(inputPassword,password);
        selectedItem(selectLanguage,language);
        clickElement(tabPermissions);
        selectedItem(rolePermissions,role);
        saveUser(email,password,role);
        clickElement(btnSave);
    }
    public void saveUser(String email, String password,String role){
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/dataTest/data_user.xlsx", "newuser");
        //Ghi giá trị "pass" vào dòng 1 cột 3 (dòng và cột bắt đầu tính từ 0)
        excel.setCellData(email, "email", 1);
        excel.setCellData(password, "password", 1);
        excel.setCellData(role, "role", 1);
    }
    public void verifyInvalid(String firstName,String lastName, String email, String password){
        setText(inputFirstName,firstName);
        setText(inputLastName,lastName);
        setText(inputEmail,email);
        setText(inputPassword,password);
        clickElement(btnSave);
    }
}
