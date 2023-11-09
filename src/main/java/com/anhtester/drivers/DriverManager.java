package com.anhtester.drivers;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    // thay cho all các giá trị driver bình thường trong project
    public static WebDriver getDriver() {
        return driver.get();
    }

    // gọi trước mỗi TC(Before)
    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    // gọi sau khi kết thúc TC(After). reset giá trị driver về null vfa xóa vị trí của driver luôn sau mỗi TC
    public static void quit() {
        if (DriverManager.driver.get() != null) {
            DriverManager.driver.get().quit();
            driver.remove();
        }
    }
}
