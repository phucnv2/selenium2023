package com.anhtester.pages.Customers;

import com.anhtester.common.BaseTest;
import com.anhtester.pages.Logins.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddNewCustomerPage extends LoginPage {
    private WebDriver driver;

    public By btnAddNewCustomerPage = By.xpath("//a[normalize-space()='New Customer']");
    public By inputCompany = By.xpath("//input[@id='company']");
    public By inputVAT = By.xpath("//input[@id='vat']");
    public By inputPhone = By.xpath("//input[@id='phonenumber']");
    public By inputWebsite = By.xpath("//input[@id='website']");
    public By groupsID = By.xpath("//select[contains(@id,'groups_in')]");
    public By currencyID = By.xpath("//select[@id='default_currency']");
    public By languageID = By.xpath("//select[@id='default_language']");
    public By inputAddress = By.xpath("//textarea[@id='address']");
    public By inputCity = By.xpath("//input[@id='city']");
    public By inputState = By.xpath("//input[@id='state']");
    public By inputZipCode = By.xpath("//input[@id='zip']");
    public By countryId = By.xpath("//select[@id='country']");
    public By btnSave = By.xpath("//div[@id='profile-save-section']//button[@class='btn btn-primary only-save customer-form-submiter']");

    public AddNewCustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickCustomer(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void senkeyTexAddNewCustomer(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    public void selectedItem(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }


}
