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
        loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        waitForPageLoaded();
        loginPage.verifyLoginFail();
    }
}
