package com.anhtester.testcases.customers;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.pages.Customers.CustomerPage;
import com.anhtester.pages.Customers.CustomerDetailPage;
import com.anhtester.pages.Logins.LoginPage;
import org.testng.annotations.Test;

public class CustomerDetailTest extends BaseTest {
    LoginPage loginPage;
    CustomerPage customerPage;
    CustomerDetailPage customerDetailPage;
    @Test
    public void customerDetail(){
        loginPage = new LoginPage();
        loginPage.loginCRM(ConfigData.EMAIL,ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
        customerPage = new CustomerPage();
        customerPage.clickCustomer();
        customerPage.verifyCustomerPage();
        customerDetailPage = new CustomerDetailPage();
        customerDetailPage.searchCustomer("aaaaaaaaa");
    }
}
