package com.framework.commonfunctionailities;

import com.framework.utils.ConfigReader;
import io.restassured.response.Response;

import java.util.Map;

public class commonMethodsForBooking {
    public String stFirstname, stLastname, stTotalPrice, stDepositPaid, stCheckin, stCheckout, stadditionalneeds = null;

    public void setVariableValues(Map<String, String> TestDataInMap) {
       stFirstname = TestDataInMap.get("firstname");
       stLastname = TestDataInMap.get("lastname");
       stTotalPrice = TestDataInMap.get("totalprice");
       stDepositPaid = TestDataInMap.get("depositpaid");
       stCheckin = TestDataInMap.get("checkin");
       stCheckout = TestDataInMap.get("checkout");
       stadditionalneeds = TestDataInMap.get("additionalneeds");
    }

    private String BuildCreateBookingRequestBody() {
       String templatePath = System.getProperty("user.dir")
               + ConfigReader.getProperty("commonpathForContentSampleFileofFramwork")
               + ConfigReader.getProperty("commonpathForBookingData");

       System.out.println("Template path: " + templatePath);
       String createBookingTemplate = commonFunctions.ReaddatafromSampleFile(templatePath);

       String requestBody = commonFunctions.XMLParameterReplacer(createBookingTemplate, "@firstname", stFirstname);
       requestBody = commonFunctions.XMLParameterReplacer(requestBody, "@lastname", stLastname);
       requestBody = commonFunctions.XMLParameterReplacer(requestBody, "@totalprice", stTotalPrice);
       requestBody = commonFunctions.XMLParameterReplacer(requestBody, "@depositpaid", stDepositPaid);
       requestBody = commonFunctions.XMLParameterReplacer(requestBody, "@checkin", stCheckin);
       requestBody = commonFunctions.XMLParameterReplacer(requestBody, "@checkout", stCheckout);
       requestBody = commonFunctions.XMLParameterReplacer(requestBody, "@additionalneeds", stadditionalneeds);
       return requestBody;
    }

    public Response postCreateBooking() {
       String bookingRequestBody = BuildCreateBookingRequestBody();
       System.out.println("Booking Request Body: " + bookingRequestBody);
       Response response = ApicommonFunctions.postBooking(bookingRequestBody);
       System.out.println("Booking Response: " + response.asString());
       return response;
    }
}

