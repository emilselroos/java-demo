package com.example;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.json.simple.JSONObject;

public class ApiServiceTest {
    @Test
    public void testFetchData() {
        ApiService apiService = new ApiService();
        apiService.fetchData();
        JSONObject data = apiService.getData();

        // Check that data is not null
        assertNotNull("Data should not be null", data);

        // Check that data contains expected content
        assertTrue("Data should contain expected content", data.data.length() > 0);
    }
}