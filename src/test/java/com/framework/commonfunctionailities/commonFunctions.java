package com.framework.commonfunctionailities;

import com.framework.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class commonFunctions {

    private static final WebDriverWait wait =
            new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));

    public static void enterValue(By locator, String value) {

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.clear();
        element.sendKeys(value);
    }

    public static void click(By locator) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }
    public static void waitForNextAction(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}