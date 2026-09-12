package com.framework.runners;
import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")

@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "com.framework.stepdefinitions,com.framework.utils"
)

@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty,html:target/cucumber-report.html"
)

@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@BookingID"
)

public class RunCucumberTests {
}