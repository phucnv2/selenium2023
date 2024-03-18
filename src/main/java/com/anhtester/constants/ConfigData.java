package com.anhtester.constants;

import com.anhtester.helpers.PropertiesHelper;

public class ConfigData {
//    public static String URL = "https://crm.anhtester.com/admin/authentication";
//    public static String EMAIL = "admin@example.com";
//    public static String PASSWORD = "123456";

    public static String URL = PropertiesHelper.getValue("url");
    public static String EMAIL = PropertiesHelper.getValue("email");
    public static String PASSWORD = PropertiesHelper.getValue("password");

    public static String SUPPER_EMAIL = PropertiesHelper.getValue("supper_email");
    public static String SUPPER_PASSWORD = PropertiesHelper.getValue("supper_password");

    public static String ADD_USER_EMAIL = PropertiesHelper.getValue("emailUser");
    public static String ADD_USER_PASSWORD = PropertiesHelper.getValue("password");
}
