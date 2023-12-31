package com.anhtester.pages.Logins;

import com.anhtester.constants.ConfigData;
import com.anhtester.pages.Dashboard.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.anhtester.keywords.ActionKeywords.*;

public class LoginPage {
    //Khai báo driver cục bộ trong chính class này
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[@id='alerts']");
    private By errorMessageEmailNull = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    private By errorMessagePasswordNull = By.xpath("//div[normalize-space()='The Password field is required.']");
    private By checkBox = By.xpath("//div[@class='checkbox checkbox-inline']//input[@id='remember']");
    private By checkBoxText = By.xpath("//label[normalize-space()='Remember me']");

    //Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng

    private void setEmail(String email) {
        setText(inputEmail,email);
    }

    private void setPassword(String password) {
        setText(inputPassword,password);
    }

    private void clickLoginButton() {
        clickElement(buttonLogin);
    }
    public void checkCheckbox(){
        clickElement(checkBoxText);
    }

    public void verifyLoginSuccess(){
        Assert.assertTrue(getCurrentUrl("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(getCurrentUrl("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(isDisplayed(errorMessage), "Error message NOT displays");
        Assert.assertEquals(getElementText(errorMessage), "Invalid email or password", "Content of error massage NOT match.");
    }
    public void verifyLoginEmailPasswordEmpty(){
        Assert.assertTrue(getCurrentUrl("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(isDisplayed(errorMessagePasswordNull), "Error message NOT displays");
        Assert.assertTrue(isDisplayed(errorMessageEmailNull), "Error message NOT displays");
        Assert.assertEquals(getElementText(errorMessagePasswordNull), "The Password field is required.", "Content of error massage NOT match.");
        Assert.assertEquals(getElementText(errorMessageEmailNull), "The Email Address field is required.", "Content of error massage NOT match.");
    }
    public void verifyEmailNull(){
        Assert.assertTrue(isDisplayed(errorMessageEmailNull),"Error messsage NOT displays");
        Assert.assertEquals(getElementText(errorMessageEmailNull),"The Email Address field is required.","Content of error massage NOT match.");
    }
    public void verifyPasswordNull(){
        Assert.assertTrue(isDisplayed(errorMessagePasswordNull),"Error message NOT display");
        Assert.assertEquals(getElementText(errorMessagePasswordNull),"The Password field is required.","Content of error massage NOT match.");
    }

    //Các hàm xử lý cho chính trang này
    public DashboardPage loginCRM(String email, String password) {
        openURL(ConfigData.URL);
        waitForPageLoaded();
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        return new DashboardPage();
    }
    public void loginPage(){
        openURL(ConfigData.URL);
        waitForPageLoaded();
    }
}
