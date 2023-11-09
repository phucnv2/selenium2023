package com.anhtester.testcases.customers;

import com.anhtester.common.BaseTest;
import com.anhtester.pages.Customers.AddNewCustomerPage;
import com.anhtester.pages.Logins.LoginPage;
import org.testng.annotations.Test;

public class AddNewCustomerTest extends BaseTest {
    AddNewCustomerPage addNewCustomerPage;
    LoginPage loginPage;
    // Text điền zô
    String companyName = "Nguyễn Văn Phúc";
    String vatNumber = "10";
    String phoneNumber = "0965339606";
    String website = "https://crm.anhtester.com/";
    String groupsId = "VIP";
    String currencyId = "USD";
    String languageId = "Vietnamese";
    String address = "số nhà 61D ngõ 145 Quan Nhân";
    String city = "Hà Nội";
    String state = "Hà Nội";
    String zipCode = "10000";
    String country = "Vietnam";

    @Test
    public void addNewCustomer() {
        addNewCustomerPage = new AddNewCustomerPage();
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123456");

        addNewCustomerPage.clickCustomer(addNewCustomerPage.btnAddNewCustomerPage);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputCompany, companyName);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputVAT, vatNumber);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputPhone, phoneNumber);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputWebsite, website);
//        Select select = new Select(driver.findElement(customerPage.groupsID));
//        select.selectByVisibleText("VIP");
        addNewCustomerPage.selectedItem(addNewCustomerPage.groupsID,groupsId);
        addNewCustomerPage.selectedItem(addNewCustomerPage.currencyID,currencyId);
        addNewCustomerPage.selectedItem(addNewCustomerPage.languageID,languageId);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputAddress,address);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputCity,city);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputState,state);
        addNewCustomerPage.senkeyTexAddNewCustomer(addNewCustomerPage.inputZipCode,zipCode);
        addNewCustomerPage.selectedItem(addNewCustomerPage.countryId,country);
        addNewCustomerPage.clickCustomer(addNewCustomerPage.btnSave);

        addNewCustomerPage.clickCustomer(addNewCustomerPage.menuCustomers);
    }
}
