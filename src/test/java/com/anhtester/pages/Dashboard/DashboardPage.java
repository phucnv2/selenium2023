package com.anhtester.pages.Dashboard;

import com.anhtester.keywords.ActionKeywords;
import com.anhtester.pages.Customers.CustomerPage;
import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.pages.NewUser.CreateUserPage;
import org.openqa.selenium.By;
import static com.anhtester.keywords.ActionKeywords.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class DashboardPage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("//ul[@class='dropdown-menu animated fadeIn']//li[@class='header-logout']//a[normalize-space()='Logout']");
    private By menuReports = By.xpath("//span[normalize-space()='Reports']");
    public By menuSetup = By.xpath("//a[@class='open-customizer']");

    public void clickMenuDashboard(){
        clickElement(menuDashboard);
    }

    public CustomerPage clickMenuCustomers(){
        clickElement(menuCustomers);
        return new CustomerPage();
    }
    public CreateUserPage clickMenuSetup(){
        clickElement(menuSetup);
        return new CreateUserPage();
    }

    public void clickMenuProjects(){
        clickElement(menuProjects);

    }

    public LoginPage logOut(){
        clickElement(dropdownProfile);
        clickElement(optionLogout);
        return new LoginPage();
    }

    public void verifyMenuReportDisplay(){
        Assert.assertTrue(ActionKeywords.checkElementExist(menuReports), "Menu Report not display.");
    }

    public void verifyMenuReportNotDisplay(){
        Assert.assertFalse(ActionKeywords.checkElementExist(menuReports), "Menu Report is displayed.");
    }

}
