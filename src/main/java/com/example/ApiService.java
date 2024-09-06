package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class ApiService {
    private String data;

    public String getData() {
        return data;
    }

    public void fetchData() {
        String apiUrl = "https://meowfacts.herokuapp.com";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();

            // Parse JSON response using Gson
            Gson gson = new Gson();
            this.data = gson.fromJson(sb.toString(), Facts.class);
        } catch (Exception e) {
            e.printStackTrace();
            this.data = new Facts();
            this.data.setFact("Error fetching data");
        }
    }
}
