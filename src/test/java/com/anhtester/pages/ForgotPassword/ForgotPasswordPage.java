package com.anhtester.pages.ForgotPassword;

import com.anhtester.constants.ConfigData;
import com.anhtester.keywords.ActionKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;

import static com.anhtester.keywords.ActionKeywords.*;

public class ForgotPasswordPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private By headerForgotPassword = By.xpath("");
    private By messageError = By.xpath("");
    private By inputEmail = By.xpath("");
    private By btnConfirm = By.xpath("");
    private By textForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new ActionKeywords(driver); //Truyền giá trị driver vào trong class WebUI
    }
    public void verifyForgotPassword(){
        Assert.assertFalse(getCurrentUrl("authentication/forgot_password"),"FAIL. Không còn ở trang Login");
//        Assert.assertTrue(isDisplayed(headerForgotPassword),"Error message NOT displays");
    }
    public void verifyEmail(){
        Assert.assertTrue(isDisplayed(messageError),"Error messsage NOT displays");
        Assert.assertEquals(getElementText(messageError),"Email not found","Content of error massage NOT match.");
    }
    public void clickForgotPassword(){
        clickElement(textForgotPassword);
    }
}
