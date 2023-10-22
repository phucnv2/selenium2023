package com.anhtester.testcases.dashboard;

import com.anhtester.pages.Customers.CustomerPage;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage(){
        //Login
//        loginPage = new LoginPage(driver);
//        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
//        loginPage.verifyLoginSuccess();
//
//        //Click menu Customer
//        customerPage = dashboardPage.clickMenuCustomers();
//        customerPage.verifyHeaderCustomerPage();

    }

    @Test
    public void testAdminRole(){
//        loginPage = new LoginPage(driver);
//        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
//        loginPage.verifyLoginSuccess();
//        dashboardPage.verifyMenuReportDisplay();
    }

    @Test
    public void testProjectRole(){
//        loginPage = new LoginPage(driver);
//        dashboardPage = loginPage.loginCRM("project@example.com", "123456");
//        loginPage.verifyLoginSuccess();
//        dashboardPage.verifyMenuReportNotDisplay();
    }

}
