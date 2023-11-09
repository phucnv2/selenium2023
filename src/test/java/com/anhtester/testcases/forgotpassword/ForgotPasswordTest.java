package com.anhtester.testcases.forgotpassword;

import com.anhtester.common.BaseTest;
import com.anhtester.pages.ForgotPassword.ForgotPasswordPage;
import com.anhtester.pages.Logins.LoginPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;
    @Test
    public void ForgotPasswordSuccess(){

    }
    @Test
    public void ForgotPasswordEmailNull(){
        loginPage = new LoginPage();
        forgotPasswordPage = new ForgotPasswordPage();
        loginPage.loginPage();
        forgotPasswordPage.clickForgotPassword();
        forgotPasswordPage.verifyForgotPassword();
    }
}
