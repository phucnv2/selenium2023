package com.anhtester.testcases.newuser;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.dataprovider.dataProviderExcel;
import com.anhtester.helpers.CaptureHelper;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.pages.Logout.LogoutPage;
import com.anhtester.pages.NewUser.CreateUserPage;
import org.testng.annotations.Test;

import static com.anhtester.keywords.ActionKeywords.sleep;

public class NewUserTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateUserPage createUserPage;
    LogoutPage logoutPage;
    @Test(priority = 1, dataProvider = "dataUser", dataProviderClass = dataProviderExcel.class)
    public void createUserSuccess(String firstName, String lastName, String email, String phone, String password, String language) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyStaffPage();
        createUserPage.insertInfomtionUser(firstName,lastName,email,phone,language, password);
    }

    @Test(priority = 1)
    public void createUserWithFirstNameInvalid() {
        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(email, password);
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
//       CaptureHelper.captureScreenshot("loginSuccess");
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyInvalid("","lastName","email@gmail.com","password");
        createUserPage.verifyFirstNameInvalid();
    }
    @Test(priority = 2)
    public void createUserWithLastNameInvalid() {
        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(email, password);
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
//       CaptureHelper.captureScreenshot("loginSuccess");
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyInvalid("firstName","","email@gmail.com","password");
        createUserPage.verifylastNameInvalid();
    }
    @Test(priority = 3)
    public void createUserWithEmailNull() {
        loginPage = new LoginPage();
//        dashboardPage = loginPage.loginCRM(email, password);
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
//       CaptureHelper.captureScreenshot("loginSuccess");
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyInvalid("firstName","lastName","","password");
        createUserPage.verifyEmaillNull();
    }
    @Test(priority = 4)
    public void createUserWithEmailInvalid() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyInvalid("firstName","firstName","email","password");
        createUserPage.verifyEmaillInvalid();
    }
    @Test(priority = 5)
    public void createUserWithPasswordInvalid() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyInvalid("firstName","firstName","email","");
        createUserPage.verifyPasswordInvalid();
    }
    @Test(priority = 1, dataProvider = "dataUser", dataProviderClass = dataProviderExcel.class)
    public void createUserSuccessAndLoginSuccess(String firstName, String lastName, String email, String phone, String password, String language) {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.verifyStaffPage();
        createUserPage.insertInfomtionUser(firstName,lastName,email,phone,language, password);
        createUserPage.verifyCreateUserSuccess();
        sleep(3);
        logoutPage = new LogoutPage();
        logoutPage.clickAdminIcon();
        logoutPage.clickLogoutButton();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("phuctho1996@gmail.com","123456");
        loginPage.verifyLoginSuccess();
    }
    @Test
    public void uploadImageTest(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.SUPPER_EMAIL, ConfigData.SUPPER_PASSWORD);
        loginPage.verifyLoginSuccess();
        createUserPage = dashboardPage.clickMenuSetup();
        createUserPage.clickMenuStaff();
        createUserPage.clickNewStaffMember();
        createUserPage.insertInfomtionUser_1("Nguyễn Văn","Phúc","phuctho1996@gmail.com","0965339606","1", "Vietnamese","Admin Example");
        createUserPage.verifyCreateUserSuccess();
        sleep(3);
        logoutPage = new LogoutPage();
        logoutPage.clickAdminIcon();
        logoutPage.clickLogoutButton();
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.ADD_USER_EMAIL, ConfigData.ADD_USER_PASSWORD); //????
        loginPage.verifyLoginSuccess();
        sleep(3);
    }
}
