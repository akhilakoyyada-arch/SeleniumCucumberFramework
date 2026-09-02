package com.framework.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    public static Map<String, String> getTestData(
            String filePath,
            String testcaseID) {

        Map<String, String> testData = new HashMap<>();

        try {

            // Read CSV from src/test/resources
            InputStream inputStream =
                    Thread.currentThread()
                            .getContextClassLoader()
                            .getResourceAsStream(filePath);

            if (inputStream == null) {
                throw new RuntimeException(
                        "CSV file not found in classpath: " + filePath);
            }

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(inputStream));

            String headerLine = reader.readLine();

            if (headerLine == null) {
                throw new RuntimeException(
                        "CSV file is empty: " + filePath);
            }

            String[] headers = headerLine.split(",");

            String line;

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                if (values.length == 0) {
                    continue;
                }

                // First column = TestCaseID
                if (values[1].trim().equals(testcaseID.trim())) {

                    for (int i = 0; i < headers.length; i++) {

                        if (i < values.length) {
                            testData.put(
                                    headers[i].trim(),
                                    values[i].trim()
                            );
                        }
                    }

                    break;
                }
            }

            reader.close();

            if (testData.isEmpty()) {
                throw new RuntimeException(
                        "TestCaseID not found in CSV: " + testcaseID);
            }

            return testData;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error reading test data: " + filePath,
                    e);
        }
    }
}