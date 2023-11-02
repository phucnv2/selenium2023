package com.anhtester.testcases.login;

import com.anhtester.constants.ConfigData;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginSuccess() {
        loginPage = new LoginPage(driver);
        //Gọi các hàm xử lý có sẵn để sử dụng
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        waitForPageLoaded(); //Khi chuyển trang mới dùng (load trang)
        loginPage.verifyLoginSuccess();
        dashboardPage.clickMenuCustomers();
    }

    @Test
    public void loginWithEmailInvalid() {
        loginPage = new LoginPage(driver);
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("adminn@example.com", ConfigData.PASSWORD);
        waitForPageLoaded();
        loginPage.verifyLoginFail();
    }
    @Test
    public void loginWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(ConfigData.EMAIL, "1234567");
        waitForPageLoaded();
        loginPage.verifyLoginFail();
    }
    @Test
    public void loginWithEmailPasswordEmpty() {
        loginPage = new LoginPage(driver);
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("", "");
        waitForPageLoaded();
        loginPage.verifyLoginEmailPasswordEmpty();
    }
    @Test
    public void loginWithEmailEmpty() {
        loginPage = new LoginPage(driver);
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("", ConfigData.PASSWORD);
        waitForPageLoaded();
        loginPage.verifyEmailNull();
    }
    @Test
    public void loginWithPasswordEmpty() {
        loginPage = new LoginPage(driver);
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(ConfigData.EMAIL, "");
        waitForPageLoaded();
        loginPage.verifyPasswordNull();
    }
    @Test
    public void chooseCheckboxRemenber(){
        loginPage = new LoginPage(driver);
        loginPage.loginPage();
        loginPage.checkCheckbox();
    }
}
