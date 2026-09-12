package com.framework.commonfunctionailities;

import com.framework.utils.ConfigReader;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApicommonFunctions {

    public static Response postBooking(String bookingRequestBody) {
        String apiBaseUrl = ConfigReader.getProperty("APIBaseUrl");
        String fullUrl = apiBaseUrl + "/booking";

        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "postman-runtime/7.32.2");
        headers.put("Accept", "application/xml");
        headers.put("Content-Type", "application/xml");

        return postRequestXML(fullUrl, headers, bookingRequestBody);
    }


    private static Response postRequestXML(String fullUrl, Map<String, String> headers, String bookingRequestBody) {
        return postRequest(fullUrl, bookingRequestBody, "application/xml", headers);
    }

    private static Response postRequest(String fullUrl, String bookingRequestBody, String contentType, Map<String, String> headers) {
        System.out.println("Post Request URL: " + fullUrl + " | contentType: " + contentType);

        return given()
                .headers(headers)
                .contentType(contentType)
                .body(bookingRequestBody)
                .when()
                .post(fullUrl)
                .then()
                .extract()
                .response();
    }
}

