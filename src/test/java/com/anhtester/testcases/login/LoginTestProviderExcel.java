package com.anhtester.testcases.login;

import com.anhtester.common.BaseTest;
import com.anhtester.dataprovider.dataProvider;
import com.anhtester.dataprovider.dataProviderExcel;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class LoginTestProviderExcel extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 7 , dataProvider = "dataLoginSuccess", dataProviderClass = dataProviderExcel.class)
    public void loginSuccess(String email, String password) {
        loginPage = new LoginPage();
        //Gọi các hàm xử lý có sẵn để sử dụng
        dashboardPage = loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
//        dashboardPage.clickMenuCustomers();
    }

    @Test(priority = 1, dataProvider = "dataEmailInValid", dataProviderClass = dataProviderExcel.class)
    public void loginWithEmailInvalid(Hashtable< String, String > data) {
        loginPage = new LoginPage();        //Gọi các hàm xử lý có sẵn để sử dụng
        loginPage.loginCRM(data.get("email"), data.get("password"));
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
