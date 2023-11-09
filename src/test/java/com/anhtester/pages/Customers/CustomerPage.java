package com.anhtester.pages.Customers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.anhtester.keywords.ActionKeywords.*;

import java.time.Duration;

public class CustomerPage{
    private WebDriver driver;
    private WebDriverWait wait;
    public By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    public By menuCustomers = By.xpath("//span[normalize-space()='Customers']");

    public void clickCustomer() {
        clickElement(menuCustomers);
    }
    public void verifyCustomerPage() {
        Assert.assertEquals(getElementText(headerCustomerPage), "Customers Summary", "Fail!");
    }
}
