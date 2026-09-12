package com.framework.stepdefinitions;

import com.framework.commonfunctionailities.ApicommonFunctions;
import com.framework.commonfunctionailities.commonMethodsForBooking;
import com.framework.utils.CsvReader;
import com.framework.utils.Settings;
import io.cucumber.java.en.Given;

import java.util.Map;
import java.util.Properties;

public class Booking_CreateAPITestStepdefinition {
    ApicommonFunctions apicommonFunctions = new ApicommonFunctions();
    commonMethodsForBooking commonMethodsForBooking = new commonMethodsForBooking();
    Map<String, String> TestDataInMap;
    public Properties properties = Settings.getInstance();

    @Given("^Launch and login to Restful Booker API (.*)$")
    public void launchAndLoginToRestfulBookerAPI(String testcaseID) {
        initializeVariableForBooking(testcaseID);
        commonMethodsForBooking.setVariableValues(TestDataInMap);
        commonMethodsForBooking.postCreateBooking();
    }

    public void initializeVariableForBooking(String testcaseID) {
        TestDataInMap = CsvReader.GetTestDataMapFromCSV(
                properties.getProperty("CommonpathForTestData") + "CreateBooking.csv",
                testcaseID
        );
    }
}
