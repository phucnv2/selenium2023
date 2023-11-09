package com.anhtester.testcases.login;

import com.anhtester.constants.ConfigData;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 7)
    public void loginSuccess() {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        dashboardPage.clickMenuCustomers();
    }

    @Test(priority = 1)
    public void loginWithEmailInvalid() {
        loginPage = new LoginPage();        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("adminn@example.com", ConfigData.PASSWORD);
        loginPage.verifyLoginFail();
    }
    @Test(priority = 2)
    public void loginWithPasswordInvalid() {
        loginPage = new LoginPage();        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(ConfigData.EMAIL, "1234567");
        loginPage.verifyLoginFail();
    }
    @Test(priority = 3)
    public void loginWithEmailPasswordEmpty() {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("", "");
        loginPage.verifyLoginEmailPasswordEmpty();
    }
    @Test(priority = 4)
    public void loginWithEmailEmpty() {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM("", ConfigData.PASSWORD);
        loginPage.verifyEmailNull();
    }
    @Test(priority = 5)
    public void loginWithPasswordEmpty() {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(ConfigData.EMAIL, "");
        loginPage.verifyPasswordNull();
    }
    @Test(priority = 6)
    public void chooseCheckboxRemenber(){
        loginPage = new LoginPage();
        loginPage.loginPage();
        loginPage.checkCheckbox();
    }
}
