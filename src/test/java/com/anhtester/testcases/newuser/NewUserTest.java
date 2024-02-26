package com.anhtester.testcases.newuser;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.dataprovider.dataProviderExcel;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.pages.NewUser.CreateUserPage;
import org.testng.annotations.Test;

import static com.anhtester.keywords.ActionKeywords.sleep;

public class NewUserTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateUserPage createUserPage;
    @Test(priority = 1, dataProvider = "dataUser", dataProviderClass = dataProviderExcel.class)
    public void createUserSuccess(String firstName, String lastName, String email, String phone, String password, String language) {
        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(email, password);
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
//        CaptureHelper.captureScreenshot("loginSuccess");
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyStaffPage();
        createUserPage.insertInfomtionUser(firstName,lastName,email,phone,language, password);
    }
//    @Test
//    public void createUserSuccess1(String firstName, String lastName, String email, String phone, String password, String language) {
//        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(email, password);
//        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
//       CaptureHelper.captureScreenshot("loginSuccess");
//        loginPage.verifyLoginSuccess();
//        createUserPage = dashboardPage.clickMenuSetup();
//        createUserPage.clickMenuStaff();
//        createUserPage.clickNewStaffMember();
//        createUserPage.verifyStaffPage();
//        createUserPage.verifyFirstNameInvalid("",lastName,email,password);
//    }
    @Test
    public void loginWithEmailInvalid() {
        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(email, password);
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
//       CaptureHelper.captureScreenshot("loginSuccess");
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyFirstNameInvalid("","lastName","email@gmail.com","password");
        createUserPage.verifyFirstNameNull();
    }
}
