package com.framework.commonfunctionailities;

import com.framework.pages.LoginpageObjects;
import com.framework.utils.ConfigReader;
import com.framework.utils.DriverManager;

public class commonMethodForLoginPage {

    public  void loginToOrangeHRM(String username, String password) {

        // Launch application
        String url = ConfigReader.getProperty("Base_url");
        DriverManager.getDriver().get(url);

        // Enter username
        commonFunctions.enterValue(
                LoginpageObjects.Username,
                username
        );

        commonFunctions.waitForNextAction(2);

        // Enter password
        commonFunctions.enterValue(
                LoginpageObjects.Password,
                password
        );

        commonFunctions.waitForNextAction(2);

        // Click login
        commonFunctions.click(
                LoginpageObjects.LoginButton
        );
    }
}