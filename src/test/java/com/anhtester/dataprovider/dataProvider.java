package com.anhtester.dataprovider;

import org.testng.annotations.DataProvider;

public class dataProvider {
    @DataProvider(name = "dataLoginSuccess", parallel = true)
    public Object[][] dataLoginSuccess() {
        return new Object[][]{
                {"admin@example.com", "123456"}
        };
    }
    @DataProvider(name = "dataEmailInValid", parallel = true)
    public Object[][] dataEmailInValid() {
        return new Object[][]{
                {"adminn@example.com", "123456"}
        };
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
