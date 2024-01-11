package com.anhtester.testcases.login;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.dataprovider.dataProvider;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import org.testng.annotations.Test;

public class LoginTestProvider extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 7 , dataProvider = "dataLoginSuccess", dataProviderClass = dataProvider.class)
    public void loginSuccess(String email, String password) {
        CaptureHelper.startRecord("loginSuccess");
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        dashboardPage = loginPage.loginCRM(email, password);
        CaptureHelper.stopRecord();
        loginPage.verifyLoginSuccess();

//        dashboardPage.clickMenuCustomers();
    }

    @Test(priority = 1, dataProvider = "dataEmailInValid", dataProviderClass = dataProvider.class)
    public void loginWithEmailInvalid(String email, String password) {
        loginPage = new LoginPage();        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginFail();
    }
    @Test(priority = 2, dataProvider = "dataPasswordInValid", dataProviderClass = dataProvider.class)
    public void loginWithPasswordInvalid(String email, String password) {
        loginPage = new LoginPage();        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginFail();
    }
    @Test(priority = 3, dataProvider = "dataEmailPasswordEmpty", dataProviderClass = dataProvider.class)
    public void loginWithEmailPasswordEmpty(String email, String password) {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginEmailPasswordEmpty();
    }
    @Test(priority = 4, dataProvider = "dataEmailEmpty", dataProviderClass = dataProvider.class)
    public void loginWithEmailEmpty(String email, String password) {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(email, password);
        loginPage.verifyEmailNull();
    }
    @Test(priority = 5, dataProvider = "dataPasswordEmpty", dataProviderClass = dataProvider.class)
    public void loginWithPasswordEmpty(String email, String password) {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(email, password);
        loginPage.verifyPasswordNull();
    }
}
