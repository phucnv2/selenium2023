package com.anhtester.testcases.customer;

import com.anhtester.pages.Customers.CustomerPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    CustomerPage customerPage;
    LoginPage loginPage;

    @Test
    public void CustomerSussess() {
        customerPage = new CustomerPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();
        customerPage.clickCustomer(customerPage.menuCustomers);
        customerPage.verifyCustomerPage();
    }
}
