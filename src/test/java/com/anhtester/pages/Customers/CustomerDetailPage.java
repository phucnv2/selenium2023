package com.anhtester.pages.Customers;

import com.anhtester.keywords.ActionKeywords.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomerDetailPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public By btnSearch = By.xpath("//div[@id='DataTables_Table_0_filter']//input[@class='form-control input-sm']");

    public void searchCustomer(String customerName){
       searchCustomer(customerName);
    }
    public void clickCustomerAfterSearch(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
}
