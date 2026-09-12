package com.framework.stepdefinitions;

import com.framework.commonfunctionailities.commonMethodForLoginPage;

import com.framework.pages.LoginpageObjects;
import com.framework.utils.ConfigReader;
import com.framework.utils.CsvReader;
import com.framework.utils.DriverManager;
import io.cucumber.java.en.Given;

import java.util.Map;

public class LoginStepdefinition {
    commonMethodForLoginPage commonMethodsForLoginPage =  new commonMethodForLoginPage();

    Map<String, String> TestDataInMap = null;

    @Given("^Launch and login to OrangeHrm application (.*)$")
    public void launchAndLoginToOrangeHRM(String testcaseID) {

        initializeVariableForLogin(testcaseID);
        commonMethodsForLoginPage.loginToOrangeHRM(TestDataInMap.get("Username") ,TestDataInMap.get("Password"));

    }

    public void initializeVariableForLogin(String testcaseID) {

        String commonPath = ConfigReader.getProperty("CommonpathForTestData");
        String filePath = commonPath + "LoginData.csv";
        TestDataInMap = CsvReader.GetTestDataMapFromCSV(filePath, testcaseID);
    }
}