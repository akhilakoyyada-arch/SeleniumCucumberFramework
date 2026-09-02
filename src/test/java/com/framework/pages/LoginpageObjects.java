package com.framework.pages;

import org.openqa.selenium.By;

public class LoginpageObjects {

    public static By Username =
            By.name("username");

    public static By Password =
            By.name("password");

    public static By LoginButton =
            By.cssSelector("button[type='submit']");
}