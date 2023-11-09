package com.anhtester.testcases.customers;

import com.anhtester.pages.Customers.CustomerPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    CustomerPage customerPage;
    LoginPage loginPage;

    @Test
    public void CustomerSussess() {
        customerPage = new CustomerPage();
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");
        customerPage.clickCustomer();
        customerPage.verifyCustomerPage();
    }
}
