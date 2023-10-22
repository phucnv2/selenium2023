package com.anhtester.pages.Customers;

import com.anhtester.pages.Logins.LoginPage;
import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CustomerPage extends LoginPage {
    private WebDriver driver;
    public By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    public CustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickCustomer(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
    public void verifyCustomerPage() {
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(), "Customers Summary", "Fail!");
    }
}
