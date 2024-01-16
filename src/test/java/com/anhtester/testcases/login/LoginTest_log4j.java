package com.anhtester.testcases.login;

import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import com.anhtester.pages.Dashboard.DashboardPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.utils.LogUtils;
import org.testng.annotations.Test;

public class LoginTest_log4j extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 7)
    public void loginSuccess() {
        LogUtils.info("Đây là log đầu tiên");
    }
}
