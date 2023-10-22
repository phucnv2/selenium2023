package com.anhtester.pages.Logout;

import com.anhtester.pages.Logins.LoginPage;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends LoginPage {
    private WebDriver driver;
    public LogoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    @Override
//    public void loginCRM(String email, String password) {
//        super.loginCRM(email, password);
//    }
}
