package com.anhtester.dataprovider;

import com.anhtester.helpers.ExcelHelper;
import org.testng.annotations.DataProvider;

public class dataProviderExcel {
    @DataProvider(name = "dataLoginSuccess", parallel = true)
    public Object[][] dataLoginSuccess() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/dataTest/Login.xlsx", "DataLogin");
        return data;
    }
    @DataProvider(name = "dataUser", parallel = true)
    public Object[][] dataUser() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/dataTest/Login.xlsx", "NewUser");
        return data;
    }
    @DataProvider(name = "saveUser", parallel = true)
    public Object[][] saveUser() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/dataTest/data_user.xlsx", "newuser");
        return data;
    }

    @DataProvider(name = "dataEmailInValid", parallel = true)
    public Object[][] dataEmailInValid() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/dataTest/Login.xlsx", "DataLogin", 2, 3);
        return data;
    }

    @DataProvider(name = "dataPasswordInValid", parallel = true)
    public Object[][] dataPasswordInValid() {
        return new Object[][]{
                {"admin@example.com", "1234567"}
        };
    }

    @DataProvider(name = "dataEmailPasswordEmpty", parallel = true)
    public Object[][] dataEmailPasswordEmpty() {
        return new Object[][]{
                {"", ""}
        };
    }

    @DataProvider(name = "dataEmailEmpty", parallel = true)
    public Object[][] dataEmailEmpty() {
        return new Object[][]{
                {"", "123456"}
        };
    }

    @DataProvider(name = "dataPasswordEmpty", parallel = true)
    public Object[][] dataPasswordEmpty() {
        return new Object[][]{
                {"admin@example.com", ""}
        };
    }

}
