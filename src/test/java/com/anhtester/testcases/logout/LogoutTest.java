package com.anhtester.testcases.logout;

import com.anhtester.pages.Logout.LogoutPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

import static com.anhtester.locators.LocatorCRM.*;

public class LogoutTest extends BaseTest {

    LogoutPage logoutPage;
    @Test
    public void logoutSuccess(){
        logoutPage = new LogoutPage(driver);
        logoutPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();
        clickElement(buttonAdminIcon);
        clickElement(buttonLogout);
    }
}
