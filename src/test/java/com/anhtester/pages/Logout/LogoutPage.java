package com.anhtester.pages.Logout;

import com.anhtester.pages.Logins.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.anhtester.keywords.ActionKeywords.clickElement;

public class LogoutPage extends LoginPage {
    public By buttonAdminIcon = By.xpath("//li[@class='icon header-user-profile']//a[@data-toggle='dropdown']");
    public By buttonLogout = By.xpath("//ul[@class='dropdown-menu animated fadeIn']//li//a[normalize-space()='Logout']");
    public void clickLogoutButton() {
        clickElement(buttonLogout);
    }
    public void clickAdminIcon(){
        clickElement(buttonAdminIcon);
    }
}
